package com.training.spring.service.impl;

import com.training.spring.dto.CheckoutProductRequestDto;
import com.training.spring.dto.CheckoutRequestDto;
import com.training.spring.dto.CheckoutResponseDto;
import com.training.spring.dto.ProductDto;
import com.training.spring.entity.Checkout;
import com.training.spring.entity.CheckoutProduct;
import com.training.spring.entity.Product;
import com.training.spring.entity.Promo;
import com.training.spring.exception.DataNotFoundException;
import com.training.spring.repository.CheckoutProductRepository;
import com.training.spring.repository.CheckoutRepository;
import com.training.spring.repository.ProductRepository;
import com.training.spring.repository.PromoRepository;
import com.training.spring.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private CheckoutProductRepository checkoutProductRepository;

    @Override
    public CheckoutResponseDto checkout(CheckoutRequestDto requestDto) {

        Promo promo = promoRepository.findPromoByCode(requestDto.getPromoCode());

        if (promo == null) {
            throw new DataNotFoundException(String.format("Promo with code %s not found", requestDto.getPromoCode()));
        }

        Long total = getTotalFromProducts(requestDto.getProducts());

        Checkout checkout = new Checkout();
        checkout.setPaidAmount(requestDto.getPaidCount());
        checkout.setDiscountAmount(promo.getDiscount());
        checkout.setTotal(total - promo.getDiscount());
        checkout.setProducts(getProducts(requestDto.getProducts()));

        checkout.getProducts().forEach(product -> checkoutProductRepository.save(product));

        Checkout insertedCheckout = checkoutRepository.save(checkout);

        CheckoutResponseDto checkoutResponseDto = new CheckoutResponseDto();
        checkoutResponseDto.setCode(HttpStatus.OK.value());
        checkoutResponseDto.setMessage("success");
        checkoutResponseDto.setPayment(insertedCheckout);

        updateItemQuantity(checkout);

        return checkoutResponseDto;
    }

    private void updateItemQuantity(Checkout checkout) {
        checkout.getProducts().forEach(checkoutProduct -> {
            Product product = productRepository.findById(checkoutProduct.getProduct().getId()).orElseThrow(() ->
                    new DataNotFoundException(String.format("Product with id %s not found",
                            checkoutProduct.getProduct().getId())));
            product.setQuantity(product.getQuantity() - checkoutProduct.getQuantity());
            productRepository.save(product);
        });
    }

    private List<CheckoutProduct> getProducts(List<CheckoutProductRequestDto> products) {
        return products.stream()
                .map(requestDto -> {
                    CheckoutProduct checkoutProduct = new CheckoutProduct();
                    checkoutProduct.setProduct(productRepository.getProductById(requestDto.getId()));
                    checkoutProduct.setQuantity(requestDto.getQuantity());

                    return checkoutProduct;
                }).collect(Collectors.toList());
    }

    private Long getTotalFromProducts(List<CheckoutProductRequestDto> products) {
        long total = 0L;
        for (CheckoutProductRequestDto product : products) {
            Product product1 = productRepository.findById(product.getId()).orElseThrow(() ->
                    new DataNotFoundException(String.format("Product with id %s not found", product.getId())));
            total += product1.getPrice() * product.getQuantity();
        }

        return total;
    }
}
