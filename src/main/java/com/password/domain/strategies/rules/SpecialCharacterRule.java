package com.password.domain.strategies.rules;

import com.password.domain.strategies.PasswordStrategy;
import org.springframework.stereotype.Service;

@Service
public class SpecialCharacterRule implements PasswordStrategy {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    @Override
    public boolean isValid(String password) {
        return password.chars().anyMatch(c -> SPECIAL_CHARACTERS.indexOf(c) >= 0);
    }
}
