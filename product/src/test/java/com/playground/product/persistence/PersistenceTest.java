package com.playground.product.persistence;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;

@DataMongoTest
@DisplayName("Product : persistence test")
public class PersistenceTest {

	private final ProductRepository productRepository;
	private Product product;

	@Autowired
	public PersistenceTest(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@BeforeEach
	void setUpDb() {
		productRepository.deleteAll();
		product = new Product(1L, "testProduct", 1);
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
		product.modifyName(modifiedName);
		productRepository.save(product);

		// when
		Product foundProduct = productRepository.findById(product.getId())
												.get();

		// then
		assertThat(1L).isEqualTo(foundProduct.getVersion());
		assertThat(modifiedName).isEqualTo(foundProduct.getName());
	}

	@Test
	void delete() {
		// when
		productRepository.delete(product);

		// then
		assertThat(productRepository.existsById(product.getId())).isFalse();
	}

	@Test
	void read() {
		// when
		Optional<Product> foundOptionalProduct = productRepository.findByProductId(product.getProductId());

		// then
		assertThat(foundOptionalProduct.isPresent()).isTrue();
		assertThat(foundOptionalProduct.get()).isEqualTo(product);
	}

	@Test
	void duplicateError() {
		// given
		Product duplicated = new Product(product.getProductId(), "duplicatedProduct", 1);

		// when/then
		assertThatThrownBy(() -> productRepository.save(duplicated)).isInstanceOf(DuplicateKeyException.class);
	}

	@Test
	void optimisticLockError() {
		// given
		Product firstConnectionProduct = productRepository.findById(product.getId())
														  .get();
		Product secondConnectionProduct = productRepository.findById(product.getId())
														   .get();
		firstConnectionProduct.modifyName("first");
		productRepository.save(firstConnectionProduct);

		// when/then
		secondConnectionProduct.modifyName("second");
		assertThatThrownBy(() -> productRepository.save(secondConnectionProduct)).isInstanceOf(
			OptimisticLockingFailureException.class);

		Product latestProduct = productRepository.findById(product.getId())
												 .get();
		assertThat(latestProduct.getName()).isEqualTo("first");
		assertThat(latestProduct.getVersion()).isEqualTo(1L);
	}
}
