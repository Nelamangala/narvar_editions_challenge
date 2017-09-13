package com.narvar.challenge.client;

import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.List;

public interface EditionClient {

    @RequestLine("GET /edition/title/word/leader-board")
    List<String> listLeaderBoard();

    @RequestLine("POST /edition")
    @Headers("Content-Type: application/json")
    void addEdition(Object payload);

    static EditionClient connect(String baseUrl) {
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .client(new feign.okhttp.OkHttpClient())
                    .target(EditionClient.class, baseUrl);
    }
}
