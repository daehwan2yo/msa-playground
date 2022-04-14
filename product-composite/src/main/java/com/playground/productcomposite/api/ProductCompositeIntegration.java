package com.playground.productcomposite.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.api.core.product.ProductApi;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.api.core.recommendation.RecommendationApi;
import com.micro.api.core.review.ReviewApi;

@Component
public class ProductCompositeIntegration implements ProductApi, ReviewApi, RecommendationApi {
	private final String PROTOCOL = "http://";

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	private final String productApiUrl;
	private final String recommendationApiUrl;
	private final String reviewApiUrl;

	@Autowired
	public ProductCompositeIntegration(RestTemplate restTemplate,
									   ObjectMapper objectMapper,
									   @Value("${app.product.host}") String productApiHost,
									   @Value("${app.product.port}") String productApiPort,
									   @Value("${app.recommendation.host}") String recommendationApiHost,
									   @Value("${app.recommendation.port}") String recommendationApiPort,
									   @Value("${app.review.host}") String reviewApiHost,
									   @Value("${app.review.port}") String reviewApiPort) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
		this.productApiUrl = makeUrl(productApiHost, productApiPort, "/product/");
		this.recommendationApiUrl = makeUrl(recommendationApiHost, recommendationApiPort, "/recommendation?productId=");
		this.reviewApiUrl = makeUrl(reviewApiHost, reviewApiPort, "/review?productId=");
	}

	private String makeUrl(String host, String port, String path) {
		return PROTOCOL + host + ":" + port + path;
	}

	// 126 2번 부터 수행
	@Override
	public ProductDto getProduct(int productId) {
		return null;
	}
}
