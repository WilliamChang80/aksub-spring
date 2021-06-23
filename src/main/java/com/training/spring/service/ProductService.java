package com.training.spring.service;

import com.training.spring.dto.*;
import com.training.spring.entity.Product;

import java.util.List;

public interface ProductService {

    void createProduct(CreateProductRequestDto requestDto);

    List<GetProductsResponseDto> getProducts();

    GetProductsResponseDto getProductById(Long id);

    void deleteProduct(Long id);

    void updateProduct(Long id, UpdateProductRequestDto requestDto);

    GetProductStatsResponseDto getProductStats();

    SearchProductResponseDto searchProduct(String query);
}
