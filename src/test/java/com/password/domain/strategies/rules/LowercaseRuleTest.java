package com.password.domain.strategies.rules;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LowercaseRuleTest {

    private LowercaseRule lowercaseRule;

    @BeforeEach
    void setUp() {
        lowercaseRule = new LowercaseRule();
    }

    @Test
    @DisplayName("Should return true for a password containing at least one lowercase letter")
    void testPasswordWithLowercaseShouldReturnTrue() {
        String password = "Password1";
        assertTrue(lowercaseRule.isValid(password), "Password should be valid as it contains a lowercase letter");
    }

    @Test
    @DisplayName("Should return false for a password without any lowercase letters")
    void testPasswordWithoutLowercaseShouldReturnFalse() {
        String password = "PASSWORD1";
        assertFalse(lowercaseRule.isValid(password), "Password should be invalid as it does not contain any lowercase letters");
    }

    @Test
    @DisplayName("Should return true for a password containing only lowercase letters")
    void testPasswordWithOnlyLowercaseShouldReturnTrue() {
        String password = "password";
        assertTrue(lowercaseRule.isValid(password), "Password should be valid as it contains only lowercase letters");
    }

    @Test
    @DisplayName("Should return false for an empty password")
    void testEmptyPasswordShouldReturnFalse() {
        String password = "";
        assertFalse(lowercaseRule.isValid(password), "Password should be invalid as it is empty and contains no lowercase letters");
    }

    @Test
    @DisplayName("Should return true for a password with mixed case letters")
    void testPasswordWithMixedCaseShouldReturnTrue() {
        String password = "PassWord1";
        assertTrue(lowercaseRule.isValid(password), "Password should be valid as it contains lowercase letters among other characters");
    }
}
