package com.test.anagram_checker.controller;

import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_ANAGRAMS;
import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_NOT_ANAGRAMS;

import com.test.anagram_checker.dto.RequestDto;
import com.test.anagram_checker.dto.ResponseDto;
import com.test.anagram_checker.service.CheckerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckerController {

    private final CheckerService checkerService;

    @PostMapping("/check")
    public ResponseDto checkAnagram(@RequestBody RequestDto requestDto){
        return checkerService.check(requestDto.firstWord(), requestDto.secondWord())
                ? new ResponseDto(THESE_WORDS_ARE_ANAGRAMS)
                : new ResponseDto(THESE_WORDS_ARE_NOT_ANAGRAMS);
    }
}
