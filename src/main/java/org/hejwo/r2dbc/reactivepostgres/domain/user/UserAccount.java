package org.hejwo.r2dbc.reactivepostgres.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hejwo.r2dbc.reactivepostgres.domain.common.Aggregate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserAccount implements Aggregate {

    @Id
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String phone;
    private String mail;
    private LocalDateTime created;

    public UserAccount(String firstName, String lastName, String phone, String mail) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
        this.created = LocalDateTime.now();
    }
}
