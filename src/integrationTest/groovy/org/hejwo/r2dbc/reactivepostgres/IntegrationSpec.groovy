package org.hejwo.r2dbc.reactivepostgres

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = [ReactivePostgresApplication])
@EnableR2dbcRepositories
abstract class IntegrationSpec extends Specification {
}
