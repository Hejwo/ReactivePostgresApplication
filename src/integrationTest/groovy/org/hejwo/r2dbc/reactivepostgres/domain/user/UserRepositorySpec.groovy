package org.hejwo.r2dbc.reactivepostgres.domain.user


import org.hejwo.r2dbc.reactivepostgres.ReactivePostgresApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = [ReactivePostgresApplication])
class UserRepositorySpec extends Specification {

    @Autowired
    UserRepository repository

    def "should save user"() {
        expect:
            println()
    }

}
