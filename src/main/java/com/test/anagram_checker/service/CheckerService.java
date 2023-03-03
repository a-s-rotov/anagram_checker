package com.test.anagram_checker.service;

import org.springframework.lang.Nullable;

public interface CheckerService {

     boolean check(@Nullable String firstWord, @Nullable String secondWord);
}
