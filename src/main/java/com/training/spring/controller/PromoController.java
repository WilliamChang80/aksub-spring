package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.CreatePromoRequestDto;
import com.training.spring.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoController {

    @Autowired
    private PromoService promoService;

    @PostMapping(Url.CREATE_PROMO_URL)
    public void createPromo(@RequestBody CreatePromoRequestDto requestDto) {
        promoService.createPromo(requestDto);
    }
}
