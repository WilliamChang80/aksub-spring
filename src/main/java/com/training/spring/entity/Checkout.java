package com.training.spring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Checkout extends BaseEntity {

    private Long paidAmount;
    private Long discountAmount;
    private Long total;

    @OneToMany
    private List<CheckoutProduct> products;
}
