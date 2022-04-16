package com.playground.productcomposite.api;

import static com.playground.productcomposite.api.util.DtoFactory.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.http.MediaType.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.micro.util.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCompositeControllerTest {
	private static final Long PRODUCT_ID_OK = 1L;
	private static final Long PRODUCT_ID_NOT_FOUND = 2L;

	private final WebTestClient webTestClient;

	@MockBean
	private ProductCompositeIntegration productCompositeIntegration;

	@Autowired
	public ProductCompositeControllerTest(WebTestClient webTestClient) {
		this.webTestClient = webTestClient;
	}

	@Test
	void getProductById() {
		// given
		willReturn(getProductDto(PRODUCT_ID_OK, "TEST", 30, "TEST")).given(productCompositeIntegration)
																	.getProduct(any());
		willReturn(List.of(getRecommendationDto(PRODUCT_ID_OK, 1L))).given(productCompositeIntegration)
																	.getRecommendations(any());
		willReturn(List.of(getReviewDto(PRODUCT_ID_OK, 1L, "TEST"))).given(productCompositeIntegration)
																	.getReviews(any());

		// when/then
		webTestClient.get()
					 .uri("/product-composite/" + PRODUCT_ID_OK)
					 .accept(APPLICATION_JSON)
					 .exchange()

					 .expectStatus()
					 .isOk()

					 .expectHeader()
					 .contentType(APPLICATION_JSON)

					 .expectBody()
					 .jsonPath("$.productId")
					 .isEqualTo(PRODUCT_ID_OK)
					 .jsonPath("$.recommendations.length()")
					 .isEqualTo(1)
					 .jsonPath("$.reviews.length()")
					 .isEqualTo(1);
	}

	@Test
	void getProductNotFound() {
		// given
		willThrow(new NotFoundException()).given(productCompositeIntegration)
										  .getProduct(any());

		// when
		webTestClient.get()
					 .uri("/product-composite/" + 2L)
					 .accept(APPLICATION_JSON)
					 .exchange()

					 .expectStatus()
					 .isNotFound()

					 .expectHeader()
					 .contentType(APPLICATION_JSON)

					 .expectBody()
					 .jsonPath("$.path")
					 .isEqualTo("/product-composite/" + PRODUCT_ID_NOT_FOUND)
					 .jsonPath("$.status")
					 .isEqualTo(404);
	}
}