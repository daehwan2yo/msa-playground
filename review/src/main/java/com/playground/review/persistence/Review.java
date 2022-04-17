package com.playground.review.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "reviews", indexes = { @Index(name = "review_unique_idx", unique = true, columnList = "productId, reviewId")})
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	private Long productId;
	private Long reviewId;
	private String author;
	private String subject;
	private String content;

	public Review() {}

	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public String getAuthor() {
		return author;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}
}
