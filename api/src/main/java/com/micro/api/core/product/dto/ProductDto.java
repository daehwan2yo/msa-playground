package com.micro.api.core.product.dto;

public class ProductDto {
	private final int productId;
	private final String name;
	private final int weight;
	private final String serviceAddress;

	public ProductDto(int productId, String name, int weight, String serviceAddress) {
		this.productId = productId;
		this.name = name;
		this.weight = weight;
		this.serviceAddress = serviceAddress;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}
}
