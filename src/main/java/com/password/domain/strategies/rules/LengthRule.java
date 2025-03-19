package com.password.domain.strategies.rules;

import com.password.domain.strategies.PasswordStrategy;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;


@Service
public class LengthRule implements PasswordStrategy {
    @Override
    public boolean isValid(String password) {
        return nonNull(password) && password.replaceAll("\\s", "").length() >= 9;
    }
}