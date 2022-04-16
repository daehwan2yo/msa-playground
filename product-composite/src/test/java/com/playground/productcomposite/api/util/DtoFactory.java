package com.playground.productcomposite.api.util;

import com.micro.api.core.product.dto.ProductDto;
import com.micro.api.core.recommendation.dto.RecommendationDto;
import com.micro.api.core.review.dto.ReviewDto;

public class DtoFactory {
	public static ProductDto getProductDto(Long id, String name, int weight, String address) {
		return new ProductDto(1L, name, weight, address);
	}

	public static RecommendationDto getRecommendationDto(Long id, Long productId) {
		return new RecommendationDto(id, productId);
	}

	public static ReviewDto getReviewDto(Long id, Long productId, String body) {
		return new ReviewDto(id, productId, body);
	}
}
