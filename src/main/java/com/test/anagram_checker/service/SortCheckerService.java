package com.test.anagram_checker.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value = "app.algorithm",
        havingValue = "SortedList")
public class SortCheckerService extends AbstractCheckerService implements CheckerService {

    @Override
    public boolean check(@Nullable String firstWord, @Nullable String secondWord) {
        if (checkStrings(firstWord, secondWord)) {
            return false;
        }

        var firstCharList = createList(firstWord);
        var secondCharList = createList(secondWord);
        return firstCharList.equals(secondCharList);
    }

    private List<Character> createList(String word) {
        return getCharacterStream(word)
                .sorted()
                .collect(Collectors.toList());
    }
}
