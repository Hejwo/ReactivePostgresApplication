package org.hejwo.r2dbc.reactivepostgres

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient

trait WebTestClientTrait {

    @Autowired
    ApplicationContext applicationContext

    WebTestClient webTestClient

    @Autowired
    ObjectMapper mapper

    @Before
    def setupWebTestClient() {
        webTestClient = createWebTestClient(applicationContext)
    }

    WebTestClient createWebTestClient(ApplicationContext applicationContext) {
        return WebTestClient
                .bindToApplicationContext(applicationContext)
                .build()
    }

}
