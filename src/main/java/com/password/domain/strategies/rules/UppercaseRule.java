package com.password.domain.strategies.rules;

import com.password.domain.strategies.PasswordStrategy;
import org.springframework.stereotype.Service;

@Service
public class UppercaseRule implements PasswordStrategy {
    @Override
    public boolean isValid(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}
