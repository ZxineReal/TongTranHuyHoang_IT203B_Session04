package bai5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionServiceTest {
    private PermissionService permissionService;
    private User admin;
    private User moderator;
    private User user;

    @BeforeEach
    void setUp() {
        permissionService = new PermissionService();

        admin = new User("admin1", Role.ADMIN);
        moderator = new User("mod1", Role.MODERATOR);
        user = new User("user1", Role.USER);
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        user = null;
    }

    @Test
    void adminShouldBeAbleToDeleteUser() {
        assertTrue(permissionService.canPerformAction(admin, Action.DELETE_USER));
    }

    @Test
    void moderatorShouldBeAbleToBanUser() {
        assertTrue(permissionService.canPerformAction(moderator, Action.BAN_USER));
    }

    @Test
    void moderatorShouldNotBeAbleToDeleteUser() {
        assertFalse(permissionService.canPerformAction(moderator, Action.DELETE_USER));
    }

    @Test
    void userShouldOnlyViewProfile() {
        assertTrue(permissionService.canPerformAction(user, Action.VIEW_PROFILE));
    }

    @Test
    void userShouldNotBanOtherUsers() {
        assertFalse(permissionService.canPerformAction(user, Action.BAN_USER));
    }
}