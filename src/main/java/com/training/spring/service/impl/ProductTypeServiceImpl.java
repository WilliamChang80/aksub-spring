package com.training.spring.service.impl;

import com.training.spring.dto.CreateProductTypeRequestDto;
import com.training.spring.entity.ProductType;
import com.training.spring.repository.ProductTypeRepository;
import com.training.spring.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void createProductType(CreateProductTypeRequestDto requestDto) {
        ProductType productType = new ProductType();
        productType.setName(requestDto.getName());
        productType.setDescription(requestDto.getDescription());

        productTypeRepository.save(productType);
    }
}
