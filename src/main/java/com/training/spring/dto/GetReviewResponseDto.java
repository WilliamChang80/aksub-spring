package com.training.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetReviewResponseDto extends BaseResponse {

    private Long productId;
    private List<ReviewDto> reviews;
}
