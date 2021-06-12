package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequestDto {

    private String name;
    private String description;
    private Long price;
}
