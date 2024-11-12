package com.renlife.cloud.demo.web.action;

import com.renlife.cloud.demo.client.CatFactClient;
import com.renlife.cloud.demo.client.dto.CatFactResponseDto;
import com.renlife.cloud.demo.exception.BadRequestException;
import com.renlife.cloud.demo.service.FactorialService;
import com.renlife.cloud.demo.service.ProductService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoAction {

    private final FactorialService factorialService;

    private final CatFactClient catFactClient;

    private final ProductService productService;

    @GetMapping({"/public/v1/factorial/{num}"})
    public String getFactorial(@NotBlank @PathVariable String num) {
        var i = Integer.parseInt(num);
        if (i > 15) {
            throw new BadRequestException("Много! Давай меньше");
        }

        return "Факториал числа %s равен %d"
                .formatted(num, factorialService.calculate(i));
    }

    @PostMapping({"/api/v1/fact"})
    public CatFactResponseDto getFact() {
        return catFactClient.getFact();
    }

    @GetMapping({"/api/v1/products"})
    public void getProducts() {
        productService.getAllProductGroups();
    }
}
