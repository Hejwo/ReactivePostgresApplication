package org.hejwo.r2dbc.reactivepostgres.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hejwo.r2dbc.reactivepostgres.domain.user.UserAccount;
import org.hejwo.r2dbc.reactivepostgres.domain.user.UserService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @RequestMapping(
            path = "/users/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<UserListItem> getAllUsers() {
        return userService.getAllUsers()
                .sort(Comparator.comparing(UserAccount::getLastName))
                .map(UserListItem::from)
                .onErrorResume(this::catchError);
    }

    private Publisher<? extends UserListItem> catchError(Throwable throwable) {
        log.error("Error while retrieving users : ",throwable);
        return Mono.just(UserListItem.empty());
    }

}
