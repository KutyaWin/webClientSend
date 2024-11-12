package com.renlife.cloud.demo.mapper;

import com.renlife.cloud.demo.persistence.entity.ProductEntity;
import com.renlife.cloud.demo.persistence.entity.ProductGroupEntity;
import com.renlife.cloud.demo.web.dto.ProductDto;
import com.renlife.cloud.demo.web.dto.ProductGroupDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductGroupMapper {

    public List<ProductGroupDto> toModelList(List<ProductGroupEntity> all) {
        List<ProductGroupDto> list = new ArrayList<>(all.size());
        for (ProductGroupEntity productGroupEntity : all) {
            list.add(productGroupEntityToProductGroupDto(productGroupEntity));
        }

        return list;
    }

    public List<ProductDto> toProducts(List<ProductEntity> entity) {
        List<ProductDto> list = new ArrayList<>(entity.size());
        for (ProductEntity productEntity : entity) {
            list.add(toProduct(productEntity));
        }

        return list;
    }

    public ProductDto toProduct(ProductEntity entity) {

        return new ProductDto()
                .setId(entity.getId())
                .setName(entity.getName());
    }

    private ProductGroupDto productGroupEntityToProductGroupDto(ProductGroupEntity productGroupEntity) {

        return new ProductGroupDto()
                .setId(productGroupEntity.getId())
                .setName(productGroupEntity.getName())
                .setProducts(toProducts(productGroupEntity.getProducts()));
    }
}
