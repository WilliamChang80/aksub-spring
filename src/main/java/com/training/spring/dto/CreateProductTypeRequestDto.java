package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductTypeRequestDto {
    private String name;
    private String description;
}
