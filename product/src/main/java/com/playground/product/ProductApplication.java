package com.playground.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.playground", "com.micro"})
public class ProductApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProductApplication.class, args);
		logDatabaseConnection(applicationContext);
		logDiscoveryConnection(applicationContext);
	}

	private static void logDatabaseConnection(ConfigurableApplicationContext applicationContext) {
		String mongoDbUri = applicationContext.getEnvironment()
											  .getProperty("spring.data.mongodb.uri");

		LOG.info("Connected to MongoDb : {}", mongoDbUri);
	}

	private static void logDiscoveryConnection(ConfigurableApplicationContext applicationContext) {
		String discoveryUri = applicationContext.getEnvironment()
												.getProperty("eureka.client.service-url");

		LOG.info("Connected to Discovery : {}", discoveryUri);
	}
}
