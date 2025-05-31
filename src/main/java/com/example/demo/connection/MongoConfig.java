package com.example.demo.connection;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoConfig {
	
	@Value("${mongo.connection.url}")
    private String mongoUrl;

    @Value("${mongo.database.name}")
    private String databaseName;
	
	 	@Bean
	    public MongoClient mongoClient() {
	        ConnectionString connStr = new ConnectionString(mongoUrl);

	        MongoClientSettings settings = MongoClientSettings.builder()
	                .applyConnectionString(connStr)
	                .applyToSocketSettings(builder -> builder
	                        .connectTimeout(10, TimeUnit.SECONDS)
	                        .readTimeout(10, TimeUnit.SECONDS))
	                .applyToClusterSettings(builder -> builder
	                        .serverSelectionTimeout(10, TimeUnit.SECONDS))
	                .build();

	        return MongoClients.create(settings);
	    }

	    @Bean
	    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
	        return mongoClient.getDatabase(databaseName); 
	    }

}
