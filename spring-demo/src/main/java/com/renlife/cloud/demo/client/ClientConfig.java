package com.renlife.cloud.demo.client;

import io.netty.handler.logging.LogLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
public class ClientConfig {

    @Bean
    public CatFactClient getClient() {
        HttpClient httpClient = HttpClient
                .create()
                .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        var webclient = WebClient.builder()
                .baseUrl("https://catfact.ninja/fact")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return new CatFactClient(webclient);
    }
}
