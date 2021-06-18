package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.CreateProductTypeRequestDto;
import com.training.spring.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping(Url.CREATE_PRODUCT_TYPE_URL)
    public void createProductType(@RequestBody CreateProductTypeRequestDto requestDto) {
        productTypeService.createProductType(requestDto);
    }
}
