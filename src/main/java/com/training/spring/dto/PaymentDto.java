package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PaymentDto {

    private Long id;
    private Date createdAt;
    private Long paidAmount;
    private Long discountAmount;
    private Long total;
    private List<ProductDto> products;
}
