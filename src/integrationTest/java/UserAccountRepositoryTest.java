import org.hejwo.r2dbc.reactivepostgres.ReactivePostgresApplication;
import org.hejwo.r2dbc.reactivepostgres.domain.user.UserAccount;
import org.hejwo.r2dbc.reactivepostgres.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = ReactivePostgresApplication.class)
@EnableR2dbcRepositories
@RunWith(SpringRunner.class)
public class UserAccountRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        UserAccount userAccount1 = new UserAccount("Piotr", "Hejwowski", "123456789", "piotr.hejwowski@at.me");

        Mono<UserAccount> save = userRepository.save(userAccount1);

        StepVerifier
                .create(save)
                .expectNext(userAccount1)
                .verifyComplete();
//        save
//                .doOnSuccess(System.out::println)
//                .doOnError(err -> {
//                    System.out.println(err);
//                }).subscribe();
    }

}
