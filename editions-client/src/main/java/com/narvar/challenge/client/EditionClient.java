package com.narvar.challenge.client;

import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.narvar.challenge.api.request.Edition;
import com.narvar.challenge.api.response.WordFrequency;
import com.narvar.challenge.api.response.WordLeaderBoard;

public interface EditionClient {

    @RequestLine("GET /edition/title/word/leader-board")
    WordLeaderBoard listLeaderBoard();
    
    @RequestLine("GET /edition/title/word/frequency")
    WordFrequency getWordFrequency(@RequestParam(value="word") String ke);

    @RequestLine("POST /edition")
    @Headers("Content-Type: application/json")
    ResponseEntity<String> addEdition(Edition payload);
    
    @RequestLine("POST /edition")
    @Headers("Content-Type: application/json")
    ResponseEntity<String> titleWordsReset(@RequestParam("size") Integer size);
    
    static EditionClient connect(String baseUrl) {
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .client(new feign.okhttp.OkHttpClient())
                    .target(EditionClient.class, baseUrl);
    }
}
