package com.playground.recommendation.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recommendations")
@CompoundIndex(name = "prod-rec-id", unique = true, def = "{'productId' : 1, 'recommendationId' : 1}")
public class Recommendation {
	@Id
	private String id;

	@Version
	private Long version;

	private Long productId;
	private Long recommendationId;
	private String author;
	private int rating;
	private String content;

	public Recommendation() {}

	public String getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getRecommendationId() {
		return recommendationId;
	}

	public String getAuthor() {
		return author;
	}

	public int getRating() {
		return rating;
	}

	public String getContent() {
		return content;
	}
}
