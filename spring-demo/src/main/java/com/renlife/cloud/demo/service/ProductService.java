package com.renlife.cloud.demo.service;

import com.renlife.cloud.demo.mapper.ProductGroupMapper;
import com.renlife.cloud.demo.persistence.repository.ProductGroupRepository;
import com.renlife.cloud.demo.web.dto.ProductGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductGroupRepository repository;

    private final ProductGroupMapper mapper;

    public List<ProductGroupDto> getAllProductGroups() {
        return mapper.toModelList(repository.findAll());
    }
}
