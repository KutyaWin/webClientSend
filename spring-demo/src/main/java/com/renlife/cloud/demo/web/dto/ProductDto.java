package com.renlife.cloud.demo.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDto {
    private Long id;
    private String name;
}
