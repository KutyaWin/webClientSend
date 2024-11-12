package com.renlife.cloud.demo.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CatFactResponseDto {
    private String facts;
}
