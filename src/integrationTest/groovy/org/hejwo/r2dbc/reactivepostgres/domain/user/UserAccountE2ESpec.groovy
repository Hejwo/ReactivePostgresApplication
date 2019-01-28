package org.hejwo.r2dbc.reactivepostgres.domain.user

import groovy.json.JsonSlurper
import org.hejwo.r2dbc.reactivepostgres.IntegrationSpec
import org.hejwo.r2dbc.reactivepostgres.WebTestClientTrait
import org.springframework.beans.factory.annotation.Autowired

class UserAccountE2ESpec extends IntegrationSpec implements WebTestClientTrait {

    @Autowired
    UserAccountRepository userAccountRepository

    def "should list all users"() {
        given:
            def account1 = userAccountRepository.save(new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me"))
            def account2 = userAccountRepository.save(new UserAccount("John", "Doe", "923456789", "john.doe@at.me"))

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
                "uuid": "f4decd61-ab6b-4e9b-920e-1ad62320fa6b",
                "firstName": "Piotr",
                "lastName": "Hejwowski",
                "email": "no@mail.please",
                "createdAt": "2019-01-28T20:24:40"
              },
              {
                "uuid": "aa3280dc-8457-4769-8134-d31ad3a7bee2",
                "firstName": "Tomasz",
                "lastName": "Tomaszewski",
                "email": "tomas@mail.please",
                "createdAt": "2019-01-28T20:24:40"
              }
            ]
        '''

            def responseMap = new JsonSlurper().parseText(response)
            responseMap[0].firstName == "Piotr"
            responseMap[0].lastName == "Hejwowski"
            responseMap[0].email == "no@mail.please"
            responseMap[0].phone == "123456789"

            println(response)
//            responseMap[1].firstName == "John"
//            responseMap[1].lastName == "Doe"
//            responseMap[1].email == "no@mail.please"
//            responseMap[1].phone == "923456789"
    }

}
