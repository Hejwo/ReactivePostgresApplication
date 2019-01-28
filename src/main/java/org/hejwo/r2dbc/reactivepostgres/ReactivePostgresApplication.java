package org.hejwo.r2dbc.reactivepostgres;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
@EnableR2dbcRepositories
public class ReactivePostgresApplication {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) {
		SpringApplication.run(ReactivePostgresApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder builderCustomizer() {
		return Jackson2ObjectMapperBuilder.json()
				.modules(new JavaTimeModule());
	}

	@Primary
	@Bean
	public ObjectMapper mapper(Jackson2ObjectMapperBuilder builderCustomizer) {
		return builderCustomizer.build();
	}

}

