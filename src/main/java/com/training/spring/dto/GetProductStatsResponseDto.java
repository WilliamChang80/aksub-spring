package com.training.spring.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Data
public class GetProductStatsResponseDto {
    private Long maxPrice;
    private Long averagePrice;
    private Long numberOfProducts;
}
