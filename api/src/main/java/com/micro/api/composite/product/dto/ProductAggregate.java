package com.micro.api.composite.product.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.micro.api.core.product.dto.ProductDto;
import com.micro.api.core.recommendation.dto.RecommendationDto;
import com.micro.api.core.review.dto.ReviewDto;

public class ProductAggregate {
	private final Long productId;
	private final String name;
	private final int weight;
	private final List<RecommendationSummary> recommendations;
	private final List<ReviewSummary> reviews;
	private final ServiceAddress serviceAddress;

	public ProductAggregate(Long productId,
							String name,
							int weight,
							List<RecommendationSummary> recommendations,
							List<ReviewSummary> reviews,
							ServiceAddress serviceAddress) {
		this.productId = productId;
		this.name = name;
		this.weight = weight;
		this.recommendations = recommendations;
		this.reviews = reviews;
		this.serviceAddress = serviceAddress;
	}

	public static ProductAggregate of(ProductDto productDto,
									  List<RecommendationDto> recommendationDtos,
									  List<ReviewDto> reviewDtos,
									  String serviceAddress) {
		return new ProductAggregate(productDto.getProductId(),
									productDto.getName(),
									productDto.getWeight(),
									recommendationDtos.stream()
													  .map(RecommendationDto::convert)
													  .collect(Collectors.toList()),
									reviewDtos.stream()
											  .map(ReviewDto::convert)
											  .collect(Collectors.toList()),
									new ServiceAddress(serviceAddress));
	}

	public static class RecommendationSummary {
		private final Long recommendationId;

		public RecommendationSummary(Long recommendationId) {
			this.recommendationId = recommendationId;
		}

		public Long getRecommendationId() {
			return recommendationId;
		}
	}

	public static class ReviewSummary {
		private final Long reviewId;
		private final String body;

		public ReviewSummary(Long reviewId, String body) {
			this.reviewId = reviewId;
			this.body = body;
		}

		public Long getReviewId() {
			return reviewId;
		}

		public String getBody() {
			return body;
		}
	}

	public static class ServiceAddress {
		private final String url;

		public ServiceAddress(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public List<RecommendationSummary> getRecommendations() {
		return recommendations;
	}

	public List<ReviewSummary> getReviews() {
		return reviews;
	}

	public ServiceAddress getServiceAddress() {
		return serviceAddress;
	}
}
