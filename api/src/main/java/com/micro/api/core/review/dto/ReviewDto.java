package com.micro.api.core.review.dto;

import com.micro.api.composite.product.dto.ProductAggregate;

public class ReviewDto {
	public ProductAggregate.ReviewSummary convert() {
		return new ProductAggregate.ReviewSummary(reviewId, body);
	}

	private Long reviewId;
	private Long ProductId;
	private String body;

	public ReviewDto() {
	}

	public ReviewDto(Long reviewId, Long productId, String body) {
		this.reviewId = reviewId;
		ProductId = productId;
		this.body = body;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public Long getProductId() {
		return ProductId;
	}

	public String getBody() {
		return body;
	}
}
