package com.password.domain.strategies.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NoRepeatedCharactersRuleTest {

    private NoRepeatedCharactersRule noRepeatedCharactersRule;

    @BeforeEach
    void setUp() {
        noRepeatedCharactersRule = new NoRepeatedCharactersRule();
    }

    @Test
    @DisplayName("Should return true for a password without repeated characters")
    void testNoRepeatedCharactersShouldReturnTrueForUniqueChars() {
        String password = "Unique1@";
        assertTrue(noRepeatedCharactersRule.isValid(password), "Password should be valid as it has no repeated characters");
    }

    @Test
    @DisplayName("Should return false for a password with repeated characters")
    void testNoRepeatedCharactersShouldReturnFalseForRepeatedChars() {
        String password = "RepeaT1!";
        assertFalse(noRepeatedCharactersRule.isValid(password), "Password should be invalid as it has repeated characters");
    }

    @Test
    @DisplayName("Should return true for a password with only one character")
    void testNoRepeatedCharactersShouldReturnTrueForSingleCharPassword() {
        String password = "A";
        assertTrue(noRepeatedCharactersRule.isValid(password), "Password should be valid as it contains only one character");
    }

    @Test
    @DisplayName("Should return true for an empty password")
    void testNoRepeatedCharactersShouldReturnTrueForEmptyPassword() {
        String password = "";
        assertTrue(noRepeatedCharactersRule.isValid(password), "Password should be valid as it is empty");
    }

    @Test
    @DisplayName("Should return false for a password with repeated characters of different types")
    void testNoRepeatedCharactersShouldReturnFalseForDifferentTypesOfRepeatedChars() {
        String password = "123@123";
        assertFalse(noRepeatedCharactersRule.isValid(password), "Password should be invalid as it has repeated characters");
    }
}