package com.training.spring.service.impl;

import com.training.spring.dto.CreateProductRequestDto;
import com.training.spring.entity.Product;
import com.training.spring.repository.ProductRepository;
import com.training.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(CreateProductRequestDto requestDto) {
        Product product = Product.builder()
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .name(requestDto.getName())
                .build();

        productRepository.save(product);
    }
}
