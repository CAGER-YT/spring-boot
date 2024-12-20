package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UseProductController {
	RestTemplate rt=new RestTemplate();
	
	@GetMapping("/getall")
	public String getall() {
		
	}
}