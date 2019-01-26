package org.hejwo.r2dbc.ReactivePostgreSql


import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = [ReactivePostgreSqlApplication])
class ReactivePostgreSqlApplicationSpec extends Specification {

    def "should load context"() {
        expect:
            print("Context loaded")
    }

}
