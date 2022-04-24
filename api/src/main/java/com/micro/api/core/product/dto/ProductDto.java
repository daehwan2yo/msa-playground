package com.micro.api.core.product.dto;

public class ProductDto {
	private Long productId;
	private String name;
	private int weight;
	private String serviceAddress;

	public ProductDto() {
	}

	public ProductDto(Long productId, String name, int weight, String serviceAddress) {
		this.productId = productId;
		this.name = name;
		this.weight = weight;
		this.serviceAddress = serviceAddress;
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

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
}
