package com.micro.api.core.product;

import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.api.core.product.dto.ProductDto;

public interface ProductApi {
	@GetMapping(value = "/product/{productId}", produces = APPLICATION_JSON_VALUE)
	ProductDto getProduct(@PathVariable Long productId);

	@PostMapping(value = "/product", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	ProductDto createProduct(@RequestBody ProductDto productDto);

	@DeleteMapping(value = "/product/{productId}")
	void removeProduct(@PathVariable Long productId);
}
