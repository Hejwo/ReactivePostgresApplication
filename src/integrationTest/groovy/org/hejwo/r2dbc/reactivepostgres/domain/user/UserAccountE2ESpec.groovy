package org.hejwo.r2dbc.reactivepostgres.domain.user


import org.hejwo.r2dbc.reactivepostgres.IntegrationSpec
import org.hejwo.r2dbc.reactivepostgres.ReactivePostgresApplication
import org.hejwo.r2dbc.reactivepostgres.WebTestClientTrait
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserAccountE2ESpec extends IntegrationSpec implements WebTestClientTrait {

    @Autowired
    UserAccountRepository userAccountRepository

    void setup() {
        userAccountRepository.deleteAll().block()
    }

    def "should list all users"() {
        given:
            def account1 = userAccountRepository.save(new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me"))
            def account2 = userAccountRepository.save(new UserAccount("John", "Doe", "923456789", "john.doe@at.me"))

            def accounts = account1.zipWith(account2).block()
            def account1Saved = accounts.getT1()
            def account2Saved = accounts.getT2()

        expect:
            def response = webTestClient.get()
                    .uri("/users/")
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(String.class)
                    .returnResult().responseBody

            def expectedResponse = '''
            [
              {
                "uuid": "UUID2",
                "firstName": "John",
                "lastName": "Doe",
                "email": "john.doe@at.me",
                "phone": "923456789",
                "createdAt": "DATE2"
              },            
              {
                "uuid": "UUID1",
                "firstName": "Piotr",
                "lastName": "Hejwowski",
                "email": "piotr.hejwowski@at.me",
                "phone": "123456789",
                "createdAt": "DATE1"
              }
            ]
        '''.replace("UUID1", account1Saved.uuid)
           .replace("UUID2", account2Saved.uuid)
           .replace("DATE1", formatDate(account1Saved.created))
           .replace("DATE2", formatDate(account2Saved.created))

        def responseMap = jsonToObject(response)
        def expectedMap = jsonToObject(expectedResponse)

        responseMap == expectedMap
    }

    String formatDate(LocalDateTime time) {
        def formatter = DateTimeFormatter.ofPattern(ReactivePostgresApplication.DEFAULT_DATE_FORMAT)
        formatter.format(time)
    }
}
