package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class WebfluxController {

	@Autowired
	WebClient c;
	
	
	@GetMapping("/hello")
	public String getString() {
		return c.get().uri("/hi").retrieve().bodyToMono(String.class).block();
	}
	
}
