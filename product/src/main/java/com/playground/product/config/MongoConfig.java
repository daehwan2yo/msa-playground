package com.playground.product.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://mongodb:27017/test");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
																	 .applyConnectionString(connectionString)
																	 .build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	protected Collection<String> getMappingBasePackages() {
		return Collections.singleton("com.playground");
	}
}
