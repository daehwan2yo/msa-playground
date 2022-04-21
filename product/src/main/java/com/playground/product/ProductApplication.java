package com.playground.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.playground", "com.micro"})
public class ProductApplication {
	// 각 micro service 는 자체적으로 디비와 연결되어 전체적으로 봤을때 구분하기 힘드므로,
	// 각 서비스가 접근하는 database를 로그로 남겨둔다.
	private static final Logger LOG = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProductApplication.class, args);
	}
}
