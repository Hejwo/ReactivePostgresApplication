package org.hejwo.r2dbc.reactivepostgres.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DataSourceConfiguration {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;

    @Autowired
    public DataSourceConfiguration(
            @Value("${spring.datasource.host}") String host,
            @Value("${spring.datasource.port}") int port,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.database}") String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }
}
