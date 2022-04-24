package com.playground.product.service;

import static com.playground.product.service.ProductValidator.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.api.core.product.dto.ProductDto;
import com.micro.util.exception.InvalidInputException;
import com.micro.util.exception.NotFoundException;
import com.playground.product.persistence.Product;
import com.playground.product.persistence.ProductRepository;

@Service
@Transactional(readOnly = true)
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductDto retrieve(Long productId) {
		verifyId(productId);
		return bindEntityToDto(productRepository.findByProductId(productId)
												.orElseThrow(() -> new NotFoundException(
													"No product found for productId : " + productId)));
	}

	@Transactional
	public ProductDto create(ProductDto productDto) {
		try {
			Product createdProduct = new Product(productDto.getProductId(),
												 productDto.getName(),
												 productDto.getWeight());
			Product savedProduct = productRepository.save(createdProduct);
			return bindEntityToDto(savedProduct);
		} catch (DuplicateKeyException e) {
			throw new InvalidInputException("error : Duplicate key, Product Id : " + productDto.getProductId());
		}
	}

	@Transactional
	public void remove(Long productId) {
		productRepository.findByProductId(productId)
						 .ifPresent(product -> productRepository.delete(product));
	}

	private ProductDto bindEntityToDto(Product savedProduct) {
		return new ProductDto(savedProduct.getProductId(), savedProduct.getName(), savedProduct.getWeight(), "");
	}
}
