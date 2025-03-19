package com.password.domain.service;

import com.password.domain.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordValidator passwordValidator;

    public boolean passwordIsValid(String password) {
        return passwordValidator.validatePassword(password);
    }
}
