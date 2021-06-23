package com.training.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Promo extends BaseEntity {

    @Column(unique = true)
    private String code;
    
    private Long discount;
}
