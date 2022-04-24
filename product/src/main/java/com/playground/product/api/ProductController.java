package com.playground.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.micro.api.core.product.ProductApi;
import com.micro.api.core.product.dto.ProductDto;
import com.micro.util.http.ApiUtil;
import com.playground.product.service.ProductService;

@RestController
public class ProductController implements ProductApi {
	private final ApiUtil apiUtil;
	private final ProductService productService;

	@Autowired
	public ProductController(ApiUtil apiUtil, ProductService productService) {
		this.apiUtil = apiUtil;
		this.productService = productService;
	}

	@Override
	public ProductDto getProduct(Long productId) {
		ProductDto retrievedProduct = productService.retrieve(productId);
		retrievedProduct.setServiceAddress(apiUtil.getServiceAddress());

		return retrievedProduct;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		return productService.create(productDto);
	}

	@Override
	public void removeProduct(Long productId) {
		productService.remove(productId);
	}
}
