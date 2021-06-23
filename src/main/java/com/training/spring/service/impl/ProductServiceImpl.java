package com.training.spring.service.impl;

import com.training.spring.dto.*;
import com.training.spring.entity.Product;
import com.training.spring.entity.ProductType;
import com.training.spring.exception.DataNotFoundException;
import com.training.spring.repository.ProductRepository;
import com.training.spring.repository.ProductTypeRepository;
import com.training.spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void createProduct(CreateProductRequestDto requestDto) {
        ProductType productType = productTypeRepository.getById(requestDto.getProductTypeId());

        Product product = Product.builder()
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .name(requestDto.getName())
                .productType(productType)
                .build();

        productRepository.save(product);
    }

    @Override
    public List<GetProductsResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> GetProductsResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .productType(product.getProductType())
                .build()).collect(Collectors.toList());
    }

    @Override
    public GetProductsResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new DataNotFoundException(
                String.format("Product with id %s not found", id)));

        return GetProductsResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.getProductById(id);

        if (product == null) {
            throw new DataNotFoundException(String.format("Product with id %s not found", id));
        }
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(Long id, UpdateProductRequestDto requestDto) {
        Product product = productRepository.getProductById(id);
        if (product == null) {
            throw new DataNotFoundException(String.format("Product with id %s not found", id));
        }

        product.setPrice(requestDto.getPrice());
        product.setDescription(requestDto.getDescription());
        product.setName(requestDto.getName());
        log.info(product.toString());
        productRepository.save(product);
    }

    @Override
    public GetProductStatsResponseDto getProductStats() {
        Long maxPrice = productRepository.getMaxProductPrice();
        Long numberOfProducts = productRepository.getNumberOfProducts();
        Long averagePrice = productRepository.getProductAveragePrice();

        return GetProductStatsResponseDto.builder()
                .maxPrice(maxPrice)
                .numberOfProducts(numberOfProducts)
                .averagePrice(averagePrice)
                .build();
    }

    @Override
    public SearchProductResponseDto searchProduct(String query) {
        List<Product> products = productRepository.findAllByNameContains(query);
        List<ProductDto> productDtoList = products.stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()).collect(Collectors.toList());

        SearchProductResponseDto responseDto = new SearchProductResponseDto();
        responseDto.setProducts(productDtoList);
        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage("success");

        return responseDto;
    }
}
