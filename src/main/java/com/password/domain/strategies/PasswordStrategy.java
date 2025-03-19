package com.password.domain.strategies;

public interface PasswordStrategy {
    boolean isValid(String password);
}