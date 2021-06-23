package com.training.spring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class CheckoutProduct extends BaseEntity {

    @OneToOne
    private Product product;

    private Long quantity;
}
