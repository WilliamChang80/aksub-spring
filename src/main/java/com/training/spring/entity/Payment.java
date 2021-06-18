package com.training.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Payment extends BaseEntity {
    private Long total;
    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;
}
