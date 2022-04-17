package com.playground.product.persistence;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
	Optional<Product> findByProductId(Long productId);
}
