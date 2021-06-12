package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.CreateProductRequestDto;
import com.training.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(Url.GET_PRODUCTS_URL)
    public String getProducts() {
        return "Testing api";
    }

    @PostMapping(Url.CREATE_PRODUCT_URL)
    public void createProduct(@RequestBody CreateProductRequestDto requestDto) {
        productService.createProduct(requestDto);
    }
}
