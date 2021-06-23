package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchProductResponseDto {

    private int code;
    private String message;
    private List<ProductDto> products;
}
