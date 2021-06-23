package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateReviewRequestDto {

    private String name;
    private Double rating;
    private String review;
}
