package com.test.anagram_checker.dto;

import org.springframework.lang.Nullable;

public record RequestDto(@Nullable String firstWord, @Nullable String secondWord) {

}
