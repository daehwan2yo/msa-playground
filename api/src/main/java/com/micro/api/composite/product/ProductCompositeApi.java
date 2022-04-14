package com.micro.api.composite.product;

import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.api.composite.product.dto.ProductAggregate;

public interface ProductCompositeApi {
	@GetMapping(value = "/product-composite/{productId}", produces = APPLICATION_JSON_VALUE)
	ProductAggregate getProduct(@PathVariable int productId);
}
