package com.training.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Review extends BaseEntity {

    private String name;
    private Double rating;
    private String review;

    @OneToOne
    private Product product;
}
