package com.password.domain.strategies.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpecialCharacterRuleTest {

    private SpecialCharacterRule specialCharacterRule;

    @BeforeEach
    void setUp() {
        specialCharacterRule = new SpecialCharacterRule();
    }

    @Test
    @DisplayName("Should return true for a password containing at least one special character")
    void testPasswordWithSpecialCharacterShouldReturnTrue() {
        String password = "Password@1";
        assertTrue(specialCharacterRule.isValid(password), "Password should be valid as it contains a special character");
    }

    @Test
    @DisplayName("Should return false for a password without any special characters")
    void testPasswordWithoutSpecialCharacterShouldReturnFalse() {
        String password = "Password1";
        assertFalse(specialCharacterRule.isValid(password), "Password should be invalid as it does not contain any special characters");
    }

    @Test
    @DisplayName("Should return true for a password containing only special characters")
    void testPasswordWithOnlySpecialCharactersShouldReturnTrue() {
        String password = "@#$%^";
        assertTrue(specialCharacterRule.isValid(password), "Password should be valid as it contains only special characters");
    }

    @Test
    @DisplayName("Should return false for an empty password")
    void testEmptyPasswordShouldReturnFalse() {
        String password = "";
        assertFalse(specialCharacterRule.isValid(password), "Password should be invalid as it is empty and contains no special characters");
    }

    @Test
    @DisplayName("Should return true for a password with special characters mixed with letters and digits")
    void testPasswordWithMixedCharsAndSpecialCharactersShouldReturnTrue() {
        String password = "Passw@rd123";
        assertTrue(specialCharacterRule.isValid(password), "Password should be valid as it contains special characters mixed with other characters");
    }
}
