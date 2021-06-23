package com.training.spring.service.impl;

import com.training.spring.dto.CreateReviewRequestDto;
import com.training.spring.dto.GetReviewResponseDto;
import com.training.spring.dto.ReviewDto;
import com.training.spring.entity.Product;
import com.training.spring.entity.Review;
import com.training.spring.exception.DataNotFoundException;
import com.training.spring.repository.ProductRepository;
import com.training.spring.repository.ReviewRepository;
import com.training.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createReview(CreateReviewRequestDto requestDto, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new DataNotFoundException("data not found"));

        Review review = new Review();
        review.setName(requestDto.getName());
        review.setRating(requestDto.getRating());
        review.setReview(requestDto.getReview());
        review.setProduct(product);

        reviewRepository.save(review);
    }

    @Override
    public GetReviewResponseDto getReview(String sort, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new DataNotFoundException("data not found"));

        List<Review> reviews = reviewRepository.findReviewsByProduct(product);
        List<ReviewDto> reviewDtoList = reviews.stream()
                .map(review -> ReviewDto.builder()
                        .review(review.getReview())
                        .name(review.getName())
                        .rating(review.getRating())
                        .build())
                .sorted(Comparator.comparing(ReviewDto::getRating))
                .collect(Collectors.toList());

        if (sort.equals("desc")) {
            Collections.reverse(reviewDtoList);
        }

        GetReviewResponseDto responseDto = new GetReviewResponseDto();
        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage("success");
        responseDto.setProductId(productId);
        responseDto.setReviews(reviewDtoList);

        return responseDto;
    }
}
