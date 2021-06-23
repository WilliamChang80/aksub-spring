package com.training.spring.service;

import com.training.spring.dto.CreateReviewRequestDto;
import com.training.spring.dto.GetReviewResponseDto;

public interface ReviewService {

    void createReview(CreateReviewRequestDto requestDto, Long productId);

    GetReviewResponseDto getReview(String sort, Long productId);
}
