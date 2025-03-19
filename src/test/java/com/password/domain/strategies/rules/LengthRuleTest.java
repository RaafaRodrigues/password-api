package com.password.domain.strategies.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LengthRuleTest {

    private LengthRule lengthRule;

    @BeforeEach
    void setUp() {
        lengthRule = new LengthRule();
    }

    @Test
    @DisplayName("Should return true for password with 9 or more characters")
    void testPasswordWithMinLengthShouldReturnTrue() {
        String password = "ValidPassword";
        assertTrue(lengthRule.isValid(password), "The password should be valid because it has 9 or more characters");
    }

    @Test
    @DisplayName("Should return false for password with less than 9 characters")
    void testPasswordWithLessThanMinLengthShouldReturnFalse() {
        String password = "Short1";
        assertFalse(lengthRule.isValid(password), "The password should be invalid because it has less than 9 characters");
    }

    @Test
    @DisplayName("Should return false for empty password")
    void testEmptyPasswordShouldReturnFalse() {
        String password = "";
        assertFalse(lengthRule.isValid(password), "The password should be invalid because it is empty");
    }

    @Test
    @DisplayName("Should return false for null password")
    void testNullPasswordShouldReturnFalse() {
        assertFalse(lengthRule.isValid(null), "The password should be invalid because it is null");
    }
}
