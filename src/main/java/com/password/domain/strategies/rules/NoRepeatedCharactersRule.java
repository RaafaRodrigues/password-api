package com.password.domain.strategies.rules;

import com.password.domain.strategies.PasswordStrategy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NoRepeatedCharactersRule implements PasswordStrategy {

    @Override
    public boolean isValid(String password) {
        return noRepeatedCharactersIn(password);
    }

    private boolean noRepeatedCharactersIn(String password) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char character : password.toCharArray()) {
            if (!seenCharacters.add(character)) {
                return false;
            }
        }
        return true;
    }
}


