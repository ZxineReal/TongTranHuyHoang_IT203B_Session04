package bai2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserService();

    @Test
    void checkRegistrationAge1() {
        assertTrue(userService.checkRegistrationAge(18));
    }

    @Test
    void checkRegistrationAge2() {
        assertFalse(userService.checkRegistrationAge(17));
    }

    @Test
    void checkRegistrationAge3() {
        assertThrows(IllegalArgumentException.class, () -> userService.checkRegistrationAge(-1));
    }
}