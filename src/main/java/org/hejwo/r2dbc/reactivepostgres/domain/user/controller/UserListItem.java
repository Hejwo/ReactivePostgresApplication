package org.hejwo.r2dbc.reactivepostgres.domain.user.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hejwo.r2dbc.reactivepostgres.domain.user.UserAccount;

import java.time.LocalDateTime;

import static org.hejwo.r2dbc.reactivepostgres.ReactivePostgresApplication.DEFAULT_DATE_FORMAT;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserListItem {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @JsonFormat(pattern = DEFAULT_DATE_FORMAT)
    private LocalDateTime createdAt;

    static UserListItem from(UserAccount userAccount) {
        return new UserListItem(
                userAccount.getUuid(),
                userAccount.getFirstName(),
                userAccount.getLastName(),
                userAccount.getMail(),
                userAccount.getPhone(),
                userAccount.getCreated()
        );
    }

    static UserListItem empty() {
        String empty = "error";
        return new UserListItem(
                empty,
                empty,
                empty,
                empty,
                empty,
                LocalDateTime.now()
        );
    }
}
