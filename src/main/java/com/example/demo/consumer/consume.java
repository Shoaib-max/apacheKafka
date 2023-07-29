package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class consume {
	
	@KafkaListener(topics = "aman", groupId = "group")
	public void listenGroupFoo(String message) {
	    System.out.println("Received Message in group foo: " + message);
	}

}
