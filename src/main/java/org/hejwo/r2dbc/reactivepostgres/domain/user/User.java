package org.hejwo.r2dbc.reactivepostgres.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hejwo.r2dbc.reactivepostgres.domain.common.Aggregate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class User implements Aggregate {

    @Id
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String phone;
    private String mail;
    private LocalDateTime created;

}
