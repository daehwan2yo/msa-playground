package com.playground.productcomposite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.micro", "com.playground"})
public class ProductCompositeApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProductCompositeApplication.class,
																				  args);

		logDiscoveryConnection(applicationContext);
	}

	private static void logDiscoveryConnection(ConfigurableApplicationContext applicationContext) {
		String discoveryUri = applicationContext.getEnvironment()
												.getProperty("eureka.client.service-url");

		LOG.info("Connected to Discovery : {}", discoveryUri);
	}
}
