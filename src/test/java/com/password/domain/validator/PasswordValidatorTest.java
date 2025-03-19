package com.password.domain.validator;

import com.password.domain.strategies.PasswordStrategy;
import com.password.domain.strategies.rules.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PasswordValidator Tests")
class PasswordValidatorTest {
    private PasswordValidator passwordValidator;
    private PasswordStrategy lengthRule;
    private PasswordStrategy digitRule;
    private PasswordStrategy lowercaseRule;
    private PasswordStrategy uppercaseRule;
    private PasswordStrategy specialCharacterRule;
    private PasswordStrategy noRepeatedCharactersRule;

    @BeforeEach
    @DisplayName("Setup mocks and initialize password validation service")
    public void setUp() {
        lengthRule = mock(LengthRule.class);
        digitRule = mock(DigitRule.class);
        lowercaseRule = mock(LowercaseRule.class);
        uppercaseRule = mock(UppercaseRule.class);
        specialCharacterRule = mock(SpecialCharacterRule.class);
        noRepeatedCharactersRule = mock(NoRepeatedCharactersRule.class);
        passwordValidator = new PasswordValidator(Arrays.asList(lengthRule, digitRule, lowercaseRule, uppercaseRule, specialCharacterRule, noRepeatedCharactersRule));

    }

    @Test
    @DisplayName("Should validate the password when all rules pass")
    void testPasswordIsValidWhenAllRulesPass() {
        String password = "Valid123!";

        when(lengthRule.isValid(password)).thenReturn(true);
        when(digitRule.isValid(password)).thenReturn(true);
        when(lowercaseRule.isValid(password)).thenReturn(true);
        when(uppercaseRule.isValid(password)).thenReturn(true);
        when(specialCharacterRule.isValid(password)).thenReturn(true);
        when(noRepeatedCharactersRule.isValid(password)).thenReturn(true);

        boolean isValid = passwordValidator.validatePassword(password);

        assertTrue(isValid);
    }

    @Test
    @DisplayName("Should invalidate the password when at least one rule fails")
    void testPasswordIsInvalidWhenOneRuleFails() {
        String password = "Invalid123";

        when(lengthRule.isValid(password)).thenReturn(true);
        when(digitRule.isValid(password)).thenReturn(true);
        when(lowercaseRule.isValid(password)).thenReturn(true);
        when(uppercaseRule.isValid(password)).thenReturn(true);
        when(specialCharacterRule.isValid(password)).thenReturn(false);

        boolean isValid = passwordValidator.validatePassword(password);

        assertFalse(isValid);
    }
}
