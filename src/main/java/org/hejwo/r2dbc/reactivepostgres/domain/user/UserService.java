package org.hejwo.r2dbc.reactivepostgres.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserAccountRepository userAccountRepository;

    public Flux<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}
