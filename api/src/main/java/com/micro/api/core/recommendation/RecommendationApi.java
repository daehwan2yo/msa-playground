package com.micro.api.core.recommendation;

import static org.springframework.http.MediaType.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.micro.api.core.recommendation.dto.RecommendationDto;

public interface RecommendationApi {
	@GetMapping(value = "/recommendation", produces = APPLICATION_JSON_VALUE)
	List<RecommendationDto> getRecommendations(@RequestParam(name = "productId") Long productId);
}
