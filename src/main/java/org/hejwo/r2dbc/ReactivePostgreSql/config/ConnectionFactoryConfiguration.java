package org.hejwo.r2dbc.ReactivePostgreSql.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactoryConfiguration {

    @Bean
    public ConnectionFactory connectionFactory(DataSourceConfiguration dataSourceConfiguration) {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host(dataSourceConfiguration.getHost())
                .port(dataSourceConfiguration.getPort())
                .database(dataSourceConfiguration.getDatabase())
                .username(dataSourceConfiguration.getUsername())
                .password(dataSourceConfiguration.getPassword())
                .build();

        return new PostgresqlConnectionFactory(config);
    }

}
