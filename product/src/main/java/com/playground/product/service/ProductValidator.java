package com.playground.product.service;

import org.springframework.stereotype.Component;

import com.micro.util.exception.InvalidInputException;
import com.micro.util.exception.NotFoundException;

@Component
public class ProductValidator {

	public void input(Long productId) {
		if (productId < 1) {
			throw new InvalidInputException("Invalid productId " + productId);
		}
		if (productId == 13) {
			throw new NotFoundException("No product found for productId " + productId);
		}
	}
}
