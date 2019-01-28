package org.hejwo.r2dbc.reactivepostgres.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hejwo.r2dbc.reactivepostgres.domain.common.Aggregate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
