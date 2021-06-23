package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.CheckoutRequestDto;
import com.training.spring.dto.CheckoutResponseDto;
import com.training.spring.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping(Url.CHECKOUT_URL)
    public CheckoutResponseDto checkout(@RequestBody CheckoutRequestDto requestDto) {
        log.info("test");
        return checkoutService.checkout(requestDto);
    }
}
