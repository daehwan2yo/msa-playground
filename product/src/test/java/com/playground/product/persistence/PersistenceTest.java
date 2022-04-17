package com.playground.product.persistence;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
@DisplayName("Product : persistence test")
public class PersistenceTest {

	private final ProductRepository productRepository;

	@Autowired
	public PersistenceTest(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@BeforeEach
	void setUpDb() {
		productRepository.deleteAll();
		Product product = new Product(1L, "testProduct", 1);
		Product savedProduct = productRepository.save(product);
		assertThat(product).isEqualTo(savedProduct);
	}

	@Test
	void create() {
		// given
		Product newProduct = new Product(2L, "new testProduct", 2);

		// when
		Product savedNewProduct = productRepository.save(newProduct);
		Product foundProduct = productRepository.findByProductId(savedNewProduct.getProductId())
												.get();

		// then
		assertThat(foundProduct).isEqualTo(savedNewProduct);
		assertThat(productRepository.count()).isEqualTo(2);
	}

	@Test
	void update() {
		// given
		String modifiedName = "testProduct2";
		Product existedProduct = productRepository.findByProductId(1L)
												  .get();
		existedProduct.modifyName(modifiedName);
		productRepository.save(existedProduct);

		// when
		Product foundProduct = productRepository.findById(existedProduct.getId())
												.get();

		// then
		assertThat(1L).isEqualTo(foundProduct.getVersion());
		assertThat(modifiedName).isEqualTo(foundProduct.getName());
	}
}
