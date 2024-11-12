package com.renlife.cloud.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Comment;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "product")
@Comment("Продукт")
public class ProductEntity {

    @Id
    @Comment("Идентификатор")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("Название продукта")
    @Column(length = 128)
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private ProductGroupEntity group;
}
