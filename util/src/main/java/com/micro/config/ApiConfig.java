package com.micro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.micro.util.http.ApiUtil;

@Configuration
public class ApiConfig {
	@Value("${server.port}")
	private String port;

	@Bean
	public ApiUtil apiUtil() {
		return new ApiUtil(port);
	}
}
