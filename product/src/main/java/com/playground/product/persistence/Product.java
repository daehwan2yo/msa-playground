package com.playground.product.persistence;

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
}
