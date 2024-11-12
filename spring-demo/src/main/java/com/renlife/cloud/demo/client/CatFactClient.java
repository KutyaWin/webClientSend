package com.renlife.cloud.demo.client;

import com.renlife.cloud.demo.client.dto.CatFactResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@RequiredArgsConstructor
public class CatFactClient {

    private final WebClient client;

    public CatFactResponseDto getFact() {
        return getCatFactResponse();
    }

    private CatFactResponseDto getCatFactResponse() {
        var response = client.get()
                .retrieve()
                .bodyToMono(CatFactResponseDto.class)
                .block();

        return Objects.requireNonNull(response);
    }
}
