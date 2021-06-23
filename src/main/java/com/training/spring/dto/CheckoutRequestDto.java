package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CheckoutRequestDto {

    private String promoCode;
    private Long paidCount;
    private List<CheckoutProductRequestDto> products;
}
