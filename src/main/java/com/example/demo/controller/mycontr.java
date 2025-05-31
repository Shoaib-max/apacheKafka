package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.produc.prodmess;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class mycontr {
	
	@Autowired
	prodmess pr;
	
	@Autowired
	MongoDatabase mongoDatabase;
	
	@GetMapping("/test")
	public String data() {

		try {

			MongoCollection<Document> coll = mongoDatabase.getCollection("productdetails");
			List<Map<String, Object>> data = coll.find().into(new LinkedList<Map<String, Object>>());
//		System.out.println(data);
			pr.sendMessage(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ok";

	}
}
