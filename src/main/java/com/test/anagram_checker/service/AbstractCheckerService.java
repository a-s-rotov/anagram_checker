package com.test.anagram_checker.service;

import java.util.stream.Stream;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

public abstract class AbstractCheckerService {

    protected boolean checkStrings(@Nullable String firstWord, @Nullable String secondWord) {
        return !StringUtils.hasText(firstWord)
                || !StringUtils.hasText(secondWord)
                || firstWord.equals(secondWord);
    }

    protected Stream<Character> getCharacterStream(@NonNull String word) {
        return word.toLowerCase().chars()
                .mapToObj(character -> (char) character)
                .filter(this::filter);
    }

    private boolean filter(Character character) {
        return Character.isAlphabetic(character) || Character.isDigit(character);
    }
}
