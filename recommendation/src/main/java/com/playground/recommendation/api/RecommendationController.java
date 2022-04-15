package com.playground.recommendation.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.micro.api.core.recommendation.RecommendationApi;
import com.micro.api.core.recommendation.dto.RecommendationDto;

@RestController
public class RecommendationController implements RecommendationApi {
	@Override
	public List<RecommendationDto> getRecommendations(Long productId) {
		return List.of(new RecommendationDto(1L, 1L), new RecommendationDto(2L, 1L), new RecommendationDto(3L, 2L));
	}
}
