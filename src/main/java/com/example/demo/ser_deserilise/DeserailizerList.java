package com.example.demo.ser_deserilise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserailizerList implements Deserializer<List<Map<String,Object>>> {

	@Override
	public List<Map<String, Object>> deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, Object>> retval = new ArrayList<Map<String,Object>>();
		
		try {
			retval = mapper.readValue(data, List.class);
		} catch (Exception e) {
			
		}
		
		
		return retval;
	}

}
