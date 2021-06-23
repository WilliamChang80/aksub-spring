package com.training.spring.controller;

import com.training.spring.constant.Url;
import com.training.spring.dto.BaseResponse;
import com.training.spring.dto.CreateReviewRequestDto;
import com.training.spring.dto.GetReviewResponseDto;
import com.training.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(Url.REVIEW_PRODUCT_URL)
    public BaseResponse createReview(@RequestBody CreateReviewRequestDto requestDto, @PathVariable Long id) {
        reviewService.createReview(requestDto, id);
        return new BaseResponse(HttpStatus.OK.value(), "success");
    }

    @GetMapping(Url.GET_REVIEW_PRODUCT_URL)
    public GetReviewResponseDto getReview(@RequestParam String sort, @PathVariable Long id) {
        return reviewService.getReview(getSortType(sort), id);
    }

    private String getSortType(String sort) {
        if (!sort.equals("asc") && !sort.equals("desc")) {
            return "asc";
        }

        return sort;
    }
}
