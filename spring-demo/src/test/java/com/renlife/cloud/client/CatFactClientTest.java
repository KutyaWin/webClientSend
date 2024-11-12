package com.renlife.cloud.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(MockitoExtension.class)
class CatFactClientTest {

    static MockWebServer mockWebServer;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void afterAll() throws Exception {
        mockWebServer.shutdown();
    }

//    CatFactClient client;
//
//    @BeforeEach
//    void beforeEach() {
//        var webClient = WebClient.builder()
//                .baseUrl(String.format("http://localhost:%s", mockWebServer.getPort()))
//                .build();
//
//        client = new CatFactClient(webClient);
//    }

    @Test
    void test() {

    }
}