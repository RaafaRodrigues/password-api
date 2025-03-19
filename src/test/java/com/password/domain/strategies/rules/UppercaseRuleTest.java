package com.password.domain.strategies.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UppercaseRuleTest {

    private UppercaseRule uppercaseRule;

    @BeforeEach
    void setUp() {
        uppercaseRule = new UppercaseRule();
    }

    @Test
    @DisplayName("Should return true for a password containing at least one uppercase letter")
    void testPasswordWithUppercaseShouldReturnTrue() {
        String password = "Password1";
        assertTrue(uppercaseRule.isValid(password), "Password should be valid as it contains an uppercase letter");
    }

    @Test
    @DisplayName("Should return false for a password without any uppercase letters")
    void testPasswordWithoutUppercaseShouldReturnFalse() {
        String password = "password1";
        assertFalse(uppercaseRule.isValid(password), "Password should be invalid as it does not contain an uppercase letter");
    }

    @Test
    @DisplayName("Should return true for a password containing only uppercase letters")
    void testPasswordWithOnlyUppercaseShouldReturnTrue() {
        String password = "PASSWORD";
        assertTrue(uppercaseRule.isValid(password), "Password should be valid as it contains only uppercase letters");
    }

    @Test
    @DisplayName("Should return false for an empty password")
    void testEmptyPasswordShouldReturnFalse() {
        String password = "";
        assertFalse(uppercaseRule.isValid(password), "Password should be invalid as it is empty and contains no uppercase letters");
    }

    @Test
    @DisplayName("Should return true for a password with uppercase letters mixed with other characters")
    void testPasswordWithMixedCharsAndUppercaseShouldReturnTrue() {
        String password = "PassW@rd123";
        assertTrue(uppercaseRule.isValid(password), "Password should be valid as it contains uppercase letters mixed with other characters");
    }
}
