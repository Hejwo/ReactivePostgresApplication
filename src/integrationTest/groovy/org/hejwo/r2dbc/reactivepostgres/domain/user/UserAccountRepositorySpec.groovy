package org.hejwo.r2dbc.reactivepostgres.domain.user

import org.hejwo.r2dbc.reactivepostgres.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class UserAccountRepositorySpec extends IntegrationSpec {

    @Autowired
    UserRepository userRepository

    def "should save user"() {
        given:
            def user = new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me")

        when:
            def savedUserMono = userRepository.save(user)

        then:
            savedUserMono.subscribe{
                aaa -> println(aaa)
            }
    }

}
