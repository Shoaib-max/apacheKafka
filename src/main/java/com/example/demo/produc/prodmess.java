package com.example.demo.produc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class prodmess {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

//	public void sendMessage(String msg) {
//	    kafkaTemplate.send("aman", msg);
//	}
	
	public void sendMessage(List<Map<String,Object>> msg) {
	    kafkaTemplate.send("aman", msg);
	}

}
