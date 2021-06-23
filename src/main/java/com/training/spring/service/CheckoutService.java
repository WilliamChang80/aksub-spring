package com.training.spring.service;

import com.training.spring.dto.CheckoutRequestDto;
import com.training.spring.dto.CheckoutResponseDto;

public interface CheckoutService {

    CheckoutResponseDto checkout(CheckoutRequestDto requestDto);
}
