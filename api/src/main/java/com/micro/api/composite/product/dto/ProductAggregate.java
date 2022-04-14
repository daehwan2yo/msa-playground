package com.micro.api.composite.product.dto;

import java.util.List;

public class ProductAggregate {
	private final int productId;
	private final String name;
	private final int weight;
	private final List<RecommendationSummary> recommendations;
	private final List<ReviewSummary> reviews;
	private final ServiceAddress serviceAddress;

	public ProductAggregate(int productId,
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

	public static class RecommendationSummary {}

	public static class ReviewSummary {}

	public static class ServiceAddress {}
}
