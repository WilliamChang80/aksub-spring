package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePromoRequestDto {

    private String code;
    private Long discount;
}
