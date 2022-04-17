package com.playground.recommendation.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.playground.recommendation.persistence.Recommendation;

public interface RecommendationRepository extends CrudRepository<Recommendation, String> {
	List<Recommendation> findAllByProductId(Long productId);
}
