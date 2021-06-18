package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateProductRequestDto {

    private String name;
    private String description;
    private Long price;
}
