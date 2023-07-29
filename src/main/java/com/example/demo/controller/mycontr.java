package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.producer;
import com.example.demo.produc.prodmess;

@RestController
public class mycontr {
	
	@Autowired
	prodmess pr;
	
	@GetMapping("/test")
	public String data() {
		pr.sendMessage("shoaib is going");
		return "ok";
		
	}
}
