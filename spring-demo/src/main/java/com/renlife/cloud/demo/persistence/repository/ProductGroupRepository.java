package com.renlife.cloud.demo.persistence.repository;

import com.renlife.cloud.demo.persistence.entity.ProductGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroupEntity, Long> {
}
