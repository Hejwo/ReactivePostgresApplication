package org.hejwo.r2dbc.reactivepostgres.config;

import lombok.Getter;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

@Configuration
@Getter
public class DataSourceConfiguration {

    private final String url;
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;

    @Autowired
    public DataSourceConfiguration(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.host}") String host,
            @Value("${spring.datasource.port}") int port,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.database}") String database) {
        this.url = url;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Bean
    @DependsOn("postgresProcess")
    public DataSource dataSource() {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUrl(url);
        pgSimpleDataSource.setUser(username);
        pgSimpleDataSource.setPassword(password);
        pgSimpleDataSource.setDatabaseName(database);

        return pgSimpleDataSource;
    }
}
