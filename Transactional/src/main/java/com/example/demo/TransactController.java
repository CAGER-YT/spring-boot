package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
public class TransactController {

	@Autowired
	SenderRepository sr;
	@Autowired
	ReciverRepository rr;
	
	@Transactional
	@PostMapping(value="/post")
	public String postMethodName(@RequestBody Transact t) {
		//TODO: process POST request
		
		sr.save(t.getSender());
		int a=10/0;
		rr.save(t.getReciver());
		
		return "Posted";
	}
	
}
