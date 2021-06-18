package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.CreateProductRequestDto;
import com.training.spring.dto.GetProductStatsResponseDto;
import com.training.spring.dto.GetProductsResponseDto;
import com.training.spring.dto.UpdateProductRequestDto;
import com.training.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(Url.GET_PRODUCTS_URL)
    public List<GetProductsResponseDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(Url.GET_PRODUCT_BY_ID_URL)
    public GetProductsResponseDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(Url.CREATE_PRODUCT_URL)
    public void createProduct(@RequestBody CreateProductRequestDto requestDto) {
        productService.createProduct(requestDto);
    }

    @DeleteMapping(Url.DELETE_PRODUCT_BY_ID_URL)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping(Url.UPDATE_PRODUCT_BY_ID_URL)
    public void updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestDto requestDto) {
        productService.updateProduct(id, requestDto);
    }

    @GetMapping(Url.GET_PRODUCT_STATS_URL)
    public GetProductStatsResponseDto getProductStats() {
        return productService.getProductStats();
    }

}
