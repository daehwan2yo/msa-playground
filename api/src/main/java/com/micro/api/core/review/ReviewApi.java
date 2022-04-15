package com.micro.api.core.review;

import static org.springframework.http.MediaType.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.micro.api.core.review.dto.ReviewDto;

public interface ReviewApi {
	@GetMapping(value = "/review", produces = APPLICATION_JSON_VALUE)
	List<ReviewDto> getReviews(@RequestParam(name = "productId") Long productId);
}
