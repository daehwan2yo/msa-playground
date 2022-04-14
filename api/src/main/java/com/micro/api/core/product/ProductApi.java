package com.micro.api.core.product;

import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.api.core.product.dto.ProductDto;

public interface ProductApi {
	@GetMapping(value = "/product/{productId}", produces = APPLICATION_JSON_VALUE)
	ProductDto getProduct(@PathVariable int productId);
}
