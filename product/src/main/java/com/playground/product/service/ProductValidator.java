package com.playground.product.service;

import com.micro.util.exception.InvalidInputException;

public class ProductValidator {

	public static void verifyId(Long productId) {
		if (productId < 1) {
			throw new InvalidInputException("Invalid productId " + productId);
		}
	}
}
