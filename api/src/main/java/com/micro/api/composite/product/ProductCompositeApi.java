package com.micro.api.composite.product;

import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.api.composite.product.dto.ProductAggregate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "REST API for composite product information.")
public interface ProductCompositeApi {

	@ApiOperation(value = "${api.product-composite.get-composite-product.description}")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Bad Request, invalid format of the request."),
		@ApiResponse(code = 404, message = "Not found, the specified id dose not exists.")
	})
	@GetMapping(value = "/product-composite/{productId}", produces = APPLICATION_JSON_VALUE)
	ProductAggregate getProduct(@PathVariable Long productId);
}
