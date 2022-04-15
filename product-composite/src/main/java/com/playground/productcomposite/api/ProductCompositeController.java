package com.playground.productcomposite.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.api.composite.product.ProductCompositeApi;
import com.micro.api.composite.product.dto.ProductAggregate;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.api.core.recommendation.dto.RecommendationDto;
import com.micro.api.core.review.dto.ReviewDto;
import com.micro.util.http.ApiUtil;

@RestController
public class ProductCompositeController implements ProductCompositeApi {
	private final ApiUtil apiUtil;
	private final ProductCompositeIntegration productCompositeIntegration;

	@Autowired
	public ProductCompositeController(ApiUtil apiUtil, ProductCompositeIntegration productCompositeIntegration) {
		this.apiUtil = apiUtil;
		this.productCompositeIntegration = productCompositeIntegration;
	}

	@GetMapping("/me")
	String test() {
		return "test";
	}

	@Override
	public ProductAggregate getProduct(Long productId) {
		ProductDto productDto = productCompositeIntegration.getProduct(productId);
		List<RecommendationDto> recommendationDtos = productCompositeIntegration.getRecommendations(productId);
		List<ReviewDto> reviewDtos = productCompositeIntegration.getReviews(productId);

		return createProductAggregate(productDto, recommendationDtos, reviewDtos, apiUtil.getServiceAddress());
	}

	private ProductAggregate createProductAggregate(ProductDto productDto,
													List<RecommendationDto> recommendationDtos,
													List<ReviewDto> reviewDtos,
													String serviceAddress) {
		return ProductAggregate.of(productDto, recommendationDtos, reviewDtos, serviceAddress);
	}
}
