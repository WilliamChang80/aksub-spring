package com.training.spring.dto;

import com.training.spring.entity.Checkout;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutResponseDto extends BaseResponse {
    private Checkout payment;
}
