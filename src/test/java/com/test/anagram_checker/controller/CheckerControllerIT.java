package com.test.anagram_checker.controller;


import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_ANAGRAMS;
import static com.test.anagram_checker.constants.ResponseMessageConstants.THESE_WORDS_ARE_NOT_ANAGRAMS;
import static org.assertj.core.api.Assertions.assertThat;

import com.test.anagram_checker.dto.RequestDto;
import com.test.anagram_checker.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CheckerControllerIT {

    @Value(value = "${local.server.port}")
    int port;

    @Autowired
    TestRestTemplate restTemplate;


    @Test
    void callEndpointPositive() {
        var requestEntity = new HttpEntity<>(new RequestDto("abaa", "baaa"));

        var response = restTemplate.exchange(
                "http://localhost:" + port + "/check", HttpMethod.POST, requestEntity,
                ResponseDto.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).extracting(ResponseDto::message)
                .isEqualTo(THESE_WORDS_ARE_ANAGRAMS);
    }

    @Test
    void callEndpointNegative() {
        var requestEntity = new HttpEntity<>(new RequestDto("aaaa", null));

        var response = restTemplate.exchange(
                "http://localhost:" + port + "/check", HttpMethod.POST, requestEntity,
                ResponseDto.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).extracting(ResponseDto::message)
                .isEqualTo(THESE_WORDS_ARE_NOT_ANAGRAMS);
    }

}
