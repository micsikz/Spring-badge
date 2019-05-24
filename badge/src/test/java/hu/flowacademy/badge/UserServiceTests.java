package hu.flowacademy.badge;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.repository.UserRepository;
import hu.flowacademy.badge.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class UserServiceTests {

    @TestConfiguration
    static class UserServiceTestConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup() {
        User userShouldBeFound = new User("Katica", "Katica Bogar", "potty ", "hat pottyos");
        Mockito.when(userRepository.findById(userShouldBeFound.getUserName())).thenReturn(Optional.of(userShouldBeFound));
        Mockito.when(userRepository.save(any(User.class))).thenReturn(userShouldBeFound);
    }

    @Test
    public void orulnekHaMuuukodnalUserName() {
        String userName= "Katica";
        User found = userService.getOneUser(userName);
        assertThat(found.getUserName()).isEqualTo(userName);
    }

    @Test
    public void csodalatosVolnaHaSaveTeisMuuukodnal() {
        User userShouldBeFound = new User("Katica", "Katica Bogar", "potty", "hat pottyos");
        User found = userService.save(userShouldBeFound);
        assertThat(found).isEqualTo(userShouldBeFound);
    }

}
