package bai6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;
    private List<User> users;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", LocalDate.of(2000,1,1)));
        users.add(new User("bob", "bob@gmail.com", LocalDate.of(1999,5,10)));
    }

    @Test
    void shouldNotUpdateProfileWhenBirthDateIsInFuture() {
        User existingUser = users.get(0);
        UserProfile newProfile =
                new UserProfile("newmail@gmail.com", LocalDate.now().plusDays(5));

        assertNull(userService.updateProfile(existingUser, newProfile, users));
    }

    @Test
    void shouldNotUpdateProfileWhenEmailAlreadyExists() {
        User existingUser = users.get(0);
        UserProfile newProfile =
                new UserProfile("bob@gmail.com", LocalDate.of(2000,1,1));

        assertNull(userService.updateProfile(existingUser, newProfile, users));
    }

    @Test
    void shouldUpdateProfileWhenEmailUniqueAndBirthDateValid() {
        User existingUser = users.get(0);
        UserProfile newProfile =
                new UserProfile("newalice@gmail.com", LocalDate.of(2001,2,2));

        assertNotNull(userService.updateProfile(existingUser, newProfile, users));
        assertEquals("newalice@gmail.com", userService.updateProfile(existingUser, newProfile, users).getEmail());
        assertEquals(LocalDate.of(2001,2,2), userService.updateProfile(existingUser, newProfile, users).getBirthDate());
    }
}