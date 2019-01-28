package org.hejwo.r2dbc.reactivepostgres.domain.user

import org.hejwo.r2dbc.reactivepostgres.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class UserAccountRepositorySpec extends IntegrationSpec {

    @Autowired
    UserAccountRepository userRepository

    void cleanup() {
        userRepository.deleteAll()
    }

    def "should save user"() {
        given:
            def user = new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me")

        when:
            def savedUserMono = userRepository.save(user)

        then:
            StepVerifier.create(savedUserMono)
                    .expectNext(user)
                    .verifyComplete()
    }

    def "should list users"() {
        given:
            def user1 = new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me")
            def user2 = new UserAccount("John", "Doe", "923456789", "john.doe@at.me")

        when:
            def foundUsers = Flux.just(user1, user2)
                    .map { user -> userRepository.save(user) }
                    .thenMany(userRepository.findAll())

        then:
            StepVerifier.create(foundUsers)
                    .expectNextCount(2)
                    .verifyComplete()
    }
}
