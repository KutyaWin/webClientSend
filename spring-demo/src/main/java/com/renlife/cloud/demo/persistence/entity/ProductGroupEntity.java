package com.renlife.cloud.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Comment;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "product_group")
@Comment("Группа продуктов")
public class ProductGroupEntity {

    @Id
    @Comment("Идентификатор")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("Название продукта")
    @Column(length = 128)
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Nullable
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<ProductEntity> products;
}
