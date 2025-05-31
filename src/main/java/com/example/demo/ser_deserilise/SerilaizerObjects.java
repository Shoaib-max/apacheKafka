package com.example.demo.ser_deserilise;

import java.util.List;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilaizerObjects implements Serializer<List<Map<String,Object>>>{

	@Override
	public byte[] serialize(String topic, List<Map<String, Object>> data) {
		ObjectMapper mapper = new ObjectMapper();
		 byte[] retval = null;
		try {
			
			retval = mapper.writeValueAsString(data).getBytes();
			
		} catch (Exception e) {
			
		}
		return retval;
	}

}
