package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.Service.TestService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class TestController {

//	@Autowired
//	TestService ts;
	
	@GetMapping("/test")
	public String getMethodName() {
		return "This is hello world";
	}
	
}
