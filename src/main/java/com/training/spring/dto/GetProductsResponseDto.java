package com.training.spring.dto;

import com.training.spring.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetProductsResponseDto {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private ProductType productType;
}
