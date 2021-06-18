package com.training.spring.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Long price;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductType productType;
}
