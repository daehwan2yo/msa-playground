package com.playground.product.persistence;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	@Id
	private String id;

	@Version
	private Long version;

	@Indexed(unique = true)
	private Long productId;

	private String name;
	private int weight;

	public Product() {}

	public Product(Long productId, String name, int weight) {
		this.productId = productId;
		this.name = name;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return id.equals(product.id) && version.equals(product.version) && productId.equals(product.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, version, productId);
	}

	public void modifyName(String modifiedName) {
		this.name = modifiedName;
	}
}
