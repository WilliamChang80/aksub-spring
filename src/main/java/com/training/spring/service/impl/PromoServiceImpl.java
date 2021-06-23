package com.training.spring.service.impl;

import com.training.spring.dto.CreatePromoRequestDto;
import com.training.spring.entity.Promo;
import com.training.spring.repository.PromoRepository;
import com.training.spring.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoRepository promoRepository;

    @Override
    public void createPromo(CreatePromoRequestDto requestDto) {
        Promo promo = new Promo();
        promo.setCode(requestDto.getCode());
        promo.setDiscount(requestDto.getDiscount());

        promoRepository.save(promo);
    }
}
