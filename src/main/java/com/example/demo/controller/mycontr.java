package com.example.demo.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.connection.MongoConfig;
import com.example.demo.produc.prodmess;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class mycontr {
	
	org.apache.logging.log4j.Logger log = LogManager.getLogger(mycontr.class);
	 Logger logger
     = LoggerFactory.getLogger(mycontr.class);
	
	@Autowired
	prodmess pr;
	
	@Autowired
	MongoConfig config;
	
	@GetMapping("/test")
	public String data() {
		
		log.info("springboot app started at " + new Date());
		logger.info("springboot app started at " + new Date());

		try {
			MongoDatabase mongoDatabase = config.mongoDatabase();
			MongoCollection<Document> coll = mongoDatabase.getCollection("productdetails");
			List<Map<String, Object>> data = coll.find().into(new LinkedList<Map<String, Object>>());
			log.info("data size : " + data.size());
			logger.info("data size : " + data.size());
//		System.out.println(data);
			pr.sendMessage(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ok";

	}
}
