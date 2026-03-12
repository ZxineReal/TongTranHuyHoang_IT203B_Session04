package bai3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {
    private UserProcessor userProcessor;

    @BeforeEach
    void setUp() {
        userProcessor = new UserProcessor();
    }

    @Test
    void shouldReturnLowercaseEmailWhenInputContainsUppercaseLetters() {
        assertEquals("example@gmail.com", userProcessor.processEmail("Example@Gmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenEmailMissingAtSymbol() {
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail("examplegmail.com");
        });
    }

    @Test
    void shouldThrowExceptionWhenEmailMissingDomain() {
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail("examplegmail.com");
        });
    }
}