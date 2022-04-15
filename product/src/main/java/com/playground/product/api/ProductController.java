package com.playground.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.micro.api.core.product.ProductApi;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.util.http.ApiUtil;
import com.playground.product.service.ProductValidator;

@RestController
public class ProductController implements ProductApi {
	private final ApiUtil apiUtil;
	private final ProductValidator productValidator;

	@Autowired
	public ProductController(ApiUtil apiUtil, ProductValidator productValidator) {
		this.apiUtil = apiUtil;
		this.productValidator = productValidator;
	}

	@Override
	public ProductDto getProduct(Long productId) {
		productValidator.input(productId);
		return new ProductDto(productId, "name-" + productId, 123, apiUtil.getServiceAddress());
	}
}
