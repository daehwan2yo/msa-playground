package com.playground.productcomposite.config;

import static springfox.documentation.builders.RequestHandlerSelectors.*;
import static springfox.documentation.spi.DocumentationType.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${api.common.version}")
	private String version;
	@Value("${api.common.title}")
	private String title;
	@Value("${api.common.description}")
	private String description;

	@Bean
	public Docket apiDocumentation() {
		return new Docket(SWAGGER_2).useDefaultResponseMessages(false)
									.apiInfo(apiInfo())
									.select()
									.apis(basePackage("com.playground.productcomposite"))
									.paths(PathSelectors.any())
									.build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title)
								   .description(description)
								   .version(version)
								   .build();
	}
}
