package com.test.anagram_checker.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SortCheckerServiceTest {

    @InjectMocks
    SortCheckerService checkerService;

    @ParameterizedTest
    @CsvFileSource(resources = "/positive_data.csv", delimiter = ':')
    void parameterizedPositiveTest(String firstWord, String secondWord) {
        assertThat(checkerService.check(firstWord,secondWord)).isTrue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/negative_data.csv", delimiter = ':')
    void parameterizedNegativeTest(String firstWord, String secondWord) {
        assertThat(checkerService.check(firstWord,secondWord)).isFalse();
    }
}
