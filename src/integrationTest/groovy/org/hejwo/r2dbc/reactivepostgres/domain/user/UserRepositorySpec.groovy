package org.hejwo.r2dbc.reactivepostgres.domain.user

import org.hejwo.r2dbc.reactivepostgres.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class UserRepositorySpec extends IntegrationSpec {

    @Autowired
    UserRepository repository

    def "should save user"() {
        expect:
            println()
    }

}
