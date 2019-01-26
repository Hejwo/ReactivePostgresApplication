package org.hejwo.r2dbc.reactivepostgres.domain.common;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AggregateRepository<T extends Aggregate> extends ReactiveCrudRepository<T, Long> {
}
