package org.hejwo.r2dbc.reactivepostgres.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {

    private final ConnectionFactory connectionFactory;

    @Autowired
    public R2dbcConfiguration(DataSourceConfiguration dataSourceConfiguration) {
        this.connectionFactory = connectionFactory(dataSourceConfiguration);
    }

    @Override
    public ConnectionFactory connectionFactory() {
        return this.connectionFactory;
    }

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
