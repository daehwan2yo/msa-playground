package com.playground.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.micro.api.core.product.ProductApi;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.util.http.ApiUtil;

@RestController
public class ProductController implements ProductApi {
	private final ApiUtil apiUtil;

	@Autowired
	public ProductController(ApiUtil apiUtil) {
		this.apiUtil = apiUtil;
	}

	@Override
	public ProductDto getProduct(int productId) {
		return new ProductDto(productId, "name-" + productId, 123, apiUtil.getServiceAddress());
	}
}
