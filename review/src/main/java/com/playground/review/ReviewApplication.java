package com.playground.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReviewApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ReviewApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ReviewApplication.class, args);
		String mySqlUrl = applicationContext.getEnvironment()
											.getProperty("spring.datasource.url");
		LOG.info("Connected to Mysql : {}", mySqlUrl);
	}
}
