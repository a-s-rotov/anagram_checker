package com.test.anagram_checker.service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="app.algorithm",
        havingValue = "HashMap",
        matchIfMissing = true)
public class HashCheckerService extends AbstractCheckerService implements CheckerService {

    @Override
    public boolean check(@Nullable String firstWord, @Nullable String secondWord) {
        if (checkStrings(firstWord, secondWord)){
            return false;
        }
        var firstMap = createMap(firstWord);
        var secondMap = createMap(secondWord);
        return firstMap.equals(secondMap);
    }

    private Map<Character, Long> createMap(String word) {
        return getCharacterStream(word)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
