package org.hejwo.r2dbc.reactivepostgres;

import org.hejwo.r2dbc.reactivepostgres.config.DataSourceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.qatools.embed.postgresql.PostgresExecutable;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class EmbeddedPostgresConfig {

    @Bean(destroyMethod = "stop", name = "postgresProcess")
    public PostgresProcess postgresProcess(PostgresConfig postgresConfig) throws IOException {
        PostgresStarter<PostgresExecutable, PostgresProcess> runtime = PostgresStarter.getDefaultInstance();
        PostgresExecutable exec = runtime.prepare(postgresConfig);
        PostgresProcess process = exec.start();

        return process;
    }

    @Bean
    public PostgresConfig postgresConfig(DataSourceConfiguration dataSource) throws IOException {
        return new PostgresConfig(
                Version.V9_5_5,
                new AbstractPostgresConfig.Net(dataSource.getHost(), dataSource.getPort()),
                new AbstractPostgresConfig.Storage(dataSource.getDatabase()),
                new AbstractPostgresConfig.Timeout(),
                new AbstractPostgresConfig.Credentials(dataSource.getUsername(), dataSource.getPassword())
        ).withAdditionalInitDbParams(Arrays.asList("-EUTF8"));
    }

}
