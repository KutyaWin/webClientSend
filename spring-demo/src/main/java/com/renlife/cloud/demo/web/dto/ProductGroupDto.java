package com.renlife.cloud.demo.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductGroupDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
