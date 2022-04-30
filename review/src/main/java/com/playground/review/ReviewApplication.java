package com.playground.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class ReviewApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ReviewApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ReviewApplication.class, args);

		logDatabaseConnection(applicationContext);
		logDiscoveryConnection(applicationContext);
	}

	private static void logDatabaseConnection(ConfigurableApplicationContext applicationContext) {
		String mySqlUrl = applicationContext.getEnvironment()
											.getProperty("spring.datasource.url");
		LOG.info("Connected to Mysql : {}", mySqlUrl);
	}

	private static void logDiscoveryConnection(ConfigurableApplicationContext applicationContext) {
		String discoveryUri = applicationContext.getEnvironment()
												.getProperty("eureka.client.service-url");

		LOG.info("Connected to Discovery : {}", discoveryUri);
	}
}
