package bai4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void shouldReturnTrueForStrongPassword() {
        assertTrue(passwordService.evaluatePasswordStrength("Strong@123"));
    }

    @Test
    void shouldReturnFalseWhenPasswordTooShort() {
        assertFalse(passwordService.evaluatePasswordStrength("S@1a"));
    }

    @Test
    void shouldReturnFalseWhenMissingUppercaseLetter() {
        assertFalse(passwordService.evaluatePasswordStrength("strong@123"));
    }

    @Test
    void shouldReturnFalseWhenMissingSpecialCharacter() {
        assertFalse(passwordService.evaluatePasswordStrength("Strong123"));
    }
}