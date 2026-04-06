package com.example;
import com.example.LoginValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    LoginValidator validator = new LoginValidator();

    @Test
    void testValidUsername() {
        assertTrue(validator.isValidUsername("admin"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidUsername("");
        });
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValidPassword("admin123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidPassword(null);
        });
    }

    @Test
    void testSuccessfulLogin() {
        assertTrue(validator.login("admin", "admin123"));
    }

    @Test
    void testFailedLogin() {
        assertFalse(validator.login("admin", "wrongpass"));
    }
}