package com.playground.product.persistence;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.playground.product.persistence.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
	Optional<Product> findByProductId(Long productId);
}
