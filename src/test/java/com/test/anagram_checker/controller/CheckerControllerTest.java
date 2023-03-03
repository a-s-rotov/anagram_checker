package com.test.anagram_checker.controller;


import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_ANAGRAMS;
import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_NOT_ANAGRAMS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.test.anagram_checker.dto.RequestDto;
import com.test.anagram_checker.dto.ResponseDto;
import com.test.anagram_checker.service.CheckerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@ExtendWith(MockitoExtension.class)
public class CheckerControllerTest {

    @InjectMocks
    CheckerController checkerController;

    @Mock
    CheckerService checkerService;

    @Test
    void callEndpoint() {
        checkerController.checkAnagram(new RequestDto("A","a"));
        verify(checkerService).check("A","a");
    }



}
