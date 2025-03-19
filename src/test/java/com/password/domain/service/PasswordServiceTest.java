package com.password.domain.service;

import com.password.domain.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PasswordService Tests")
class PasswordServiceTest {

    private PasswordService passwordService;
    private PasswordValidator passwordValidator;

    @BeforeEach
    @DisplayName("Setup mocks and initialize password service")
    public void setUp() {
        passwordValidator = mock(PasswordValidator.class);
        passwordService = new PasswordService(passwordValidator);
    }

    @Test
    @DisplayName("Should validate the password when all rules pass")
    void testPasswordIsValidWhenAllRulesPass() {
        String password = "Valid123!";

        when(passwordValidator.validatePassword(password)).thenReturn(true);

        boolean isValid = passwordService.passwordIsValid(password);

        assertTrue(isValid);
    }

    @Test
    @DisplayName("Should invalidate the password when at least one rule fails")
    void testPasswordIsInvalidWhenOneRuleFails() {
        String password = "Invalid123";
        when(passwordValidator.validatePassword(password)).thenReturn(false);

        boolean isValid = passwordService.passwordIsValid(password);

        assertFalse(isValid);
    }
}

