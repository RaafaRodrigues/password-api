package com.password.domain.strategies.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DigitRuleTest {

    private DigitRule digitRule;

    @BeforeEach
    void setUp() {
        digitRule = new DigitRule();
    }

    @Test
    @DisplayName("Should return true for a password containing at least one digit")
    void testPasswordWithDigitShouldReturnTrue() {
        String password = "Password1";
        assertTrue(digitRule.isValid(password), "Password should be valid as it contains a digit");
    }

    @Test
    @DisplayName("Should return false for a password without any digits")
    void testPasswordWithoutDigitShouldReturnFalse() {
        String password = "Password";
        assertFalse(digitRule.isValid(password), "Password should be invalid as it does not contain any digits");
    }

    @Test
    @DisplayName("Should return true for a password containing only digits")
    void testPasswordWithOnlyDigitsShouldReturnTrue() {
        String password = "123456";
        assertTrue(digitRule.isValid(password), "Password should be valid as it contains only digits");
    }

    @Test
    @DisplayName("Should return false for an empty password")
    void testEmptyPasswordShouldReturnFalse() {
        String password = "";
        assertFalse(digitRule.isValid(password), "Password should be invalid as it is empty and contains no digits");
    }

    @Test
    @DisplayName("Should return true for a password with digits mixed with characters")
    void testPasswordWithMixedCharsAndDigitsShouldReturnTrue() {
        String password = "abc123";
        assertTrue(digitRule.isValid(password), "Password should be valid as it contains digits mixed with characters");
    }
}
