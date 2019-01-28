package org.hejwo.r2dbc.reactivepostgres

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = [ReactivePostgresApplication])
abstract class IntegrationSpec extends Specification {
}
