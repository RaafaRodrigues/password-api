package com.password.domain.validator;

import com.password.domain.strategies.PasswordStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PasswordValidator {
    private final List<PasswordStrategy> rules;

    public boolean validatePassword(String password) {
        return rules.stream().allMatch(rule -> rule.isValid(password));
    }
}
