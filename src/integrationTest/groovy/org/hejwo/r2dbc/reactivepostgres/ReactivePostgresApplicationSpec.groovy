package org.hejwo.r2dbc.reactivepostgres

class ReactivePostgresApplicationSpec extends IntegrationSpec {

    def "should load context"() {
        expect:
            print("Context loaded")
    }

}
