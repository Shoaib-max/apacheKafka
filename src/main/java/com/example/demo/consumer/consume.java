package com.example.demo.consumer;

import java.util.List;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class consume {
	
	@KafkaListener(topics = "aman", groupId = "group")
	public void listenGroupFoo(List<Map<String,Object>> message) {
	    System.out.println("Received Message in group foo: " + message);
	    
	    for(Map<String,Object> mp : message) {
	    	System.out.println(mp);
	    }
	}

}
