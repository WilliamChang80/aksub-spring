package com.training.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Table(name = "product_types")
@Entity
public class ProductType extends BaseEntity {

    private String name;
    private String description;
}
