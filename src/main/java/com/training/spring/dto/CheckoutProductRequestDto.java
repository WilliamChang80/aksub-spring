package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutProductRequestDto {

    private Long id;
    private Long quantity;
}
