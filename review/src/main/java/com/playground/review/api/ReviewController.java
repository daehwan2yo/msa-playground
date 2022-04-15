package com.playground.review.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.micro.api.core.review.ReviewApi;
import com.micro.api.core.review.dto.ReviewDto;

@RestController
public class ReviewController implements ReviewApi {
	@Override
	public List<ReviewDto> getReviews(Long productId) {
		return List.of(new ReviewDto(1L, 1L, "good"),
					   new ReviewDto(2L, 1L, "so good"),
					   new ReviewDto(3L, 2L, "not bad"));
	}
}
