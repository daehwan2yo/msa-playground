package com.micro.api.core.recommendation.dto;

import com.micro.api.composite.product.dto.ProductAggregate;

public class RecommendationDto {
	public ProductAggregate.RecommendationSummary convert() {
		return new ProductAggregate.RecommendationSummary(getRecommendationId());
	}

	private Long RecommendationId;
	private Long productId;

	public RecommendationDto() {
	}

	public RecommendationDto(Long recommendationId, Long productId) {
		RecommendationId = recommendationId;
		this.productId = productId;
	}

	public Long getRecommendationId() {
		return RecommendationId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setRecommendationId(Long recommendationId) {
		RecommendationId = recommendationId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
