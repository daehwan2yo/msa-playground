package com.playground.productcomposite.api;

import static org.springframework.http.HttpMethod.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.api.core.product.ProductApi;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.api.core.recommendation.RecommendationApi;
import com.micro.api.core.recommendation.dto.RecommendationDto;
import com.micro.api.core.review.ReviewApi;
import com.micro.api.core.review.dto.ReviewDto;
import com.micro.util.exception.InvalidInputException;
import com.micro.util.exception.NotFoundException;
import com.micro.util.http.ApiUtil;

@Component
public class ProductCompositeIntegration implements ProductApi, ReviewApi, RecommendationApi {
	private static final Logger LOG = LoggerFactory.getLogger(ApiUtil.class);
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

	@Override
	public ProductDto getProduct(Long productId) {
		String url = productApiUrl + productId;
		ProductDto productDto = null;

		try {
			productDto = restTemplate.getForObject(url, ProductDto.class);
		} catch (HttpClientErrorException ex) {
			switch (ex.getStatusCode()) {
				case NOT_FOUND:
					throw new NotFoundException(ex.getMessage());
				case UNPROCESSABLE_ENTITY:
					throw new InvalidInputException(ex.getMessage());
				default:
					LOG.warn("Got a unexpected HTTP error : {}, will rethrow it", ex.getStatusCode());
					LOG.warn("Error Body : {}", ex.getResponseBodyAsString());
			}
		}
		return productDto;
	}

	@Override
	public List<RecommendationDto> getRecommendations(Long productId) {
		String url = recommendationApiUrl + productId;
		List<RecommendationDto> recommendationDtos = restTemplate.exchange(url,
																		   GET,
																		   null,
																		   new ParameterizedTypeReference<List<RecommendationDto>>() {})
																 .getBody();
		return recommendationDtos;
	}

	@Override
	public List<ReviewDto> getReviews(Long productId) {
		String url = reviewApiUrl + productId;
		List<ReviewDto> reviewDtos = restTemplate.exchange(url,
														   GET,
														   null,
														   new ParameterizedTypeReference<List<ReviewDto>>() {})
												 .getBody();
		return reviewDtos;
	}
}
