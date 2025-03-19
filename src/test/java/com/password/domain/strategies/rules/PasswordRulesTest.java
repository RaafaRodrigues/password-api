package com.password.domain.strategies.rules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Password Rule Tests")
class PasswordRulesTest {

    @Test
    @DisplayName("LengthRule should return true for passwords with at least 9 characters")
    void testLengthRuleValidPassword() {
        LengthRule rule = new LengthRule();
        assertTrue(rule.isValid("ValidPass1"));
    }

    @Test
    @DisplayName("LengthRule should return false for passwords with less than 9 characters")
    void testLengthRuleInvalidPassword() {
        LengthRule rule = new LengthRule();
        assertFalse(rule.isValid("Short1"));
    }

    @Test
    @DisplayName("DigitRule should return true for passwords containing at least one digit")
    void testDigitRuleValidPassword() {
        DigitRule rule = new DigitRule();
        assertTrue(rule.isValid("Password1"));
    }

    @Test
    @DisplayName("DigitRule should return false for passwords without digits")
    void testDigitRuleInvalidPassword() {
        DigitRule rule = new DigitRule();
        assertFalse(rule.isValid("Password"));
    }

    @Test
    @DisplayName("LowercaseRule should return true for passwords containing at least one lowercase letter")
    void testLowercaseRuleValidPassword() {
        LowercaseRule rule = new LowercaseRule();
        assertTrue(rule.isValid("PassWord"));
    }

    @Test
    @DisplayName("LowercaseRule should return false for passwords without lowercase letters")
    void testLowercaseRuleInvalidPassword() {
        LowercaseRule rule = new LowercaseRule();
        assertFalse(rule.isValid("PASSWORD1"));
    }

    @Test
    @DisplayName("UppercaseRule should return true for passwords containing at least one uppercase letter")
    void testUppercaseRuleValidPassword() {
        UppercaseRule rule = new UppercaseRule();
        assertTrue(rule.isValid("passWord1"));
    }

    @Test
    @DisplayName("UppercaseRule should return false for passwords without uppercase letters")
    void testUppercaseRuleInvalidPassword() {
        UppercaseRule rule = new UppercaseRule();
        assertFalse(rule.isValid("password1"));
    }

    @Test
    @DisplayName("SpecialCharacterRule should return true for passwords containing at least one special character")
    void testSpecialCharacterRuleValidPassword() {
        SpecialCharacterRule rule = new SpecialCharacterRule();
        assertTrue(rule.isValid("Password1!"));
    }

    @Test
    @DisplayName("SpecialCharacterRule should return false for passwords without special characters")
    void testSpecialCharacterRuleInvalidPassword() {
        SpecialCharacterRule rule = new SpecialCharacterRule();
        assertFalse(rule.isValid("Password1"));
    }
}

