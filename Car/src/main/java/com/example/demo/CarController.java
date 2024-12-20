package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private CarService cs;
	
	@PostMapping("/post")
	public String postData(@RequestBody Car c) {
		//TODO: process POST request
		
		return cs.postData(c);
	}
	
//	@GetMapping("/get/{id}")
//	public Car getData(@PathVariable int id) {
//		return cs.getData(id);
//	}
	@GetMapping("/get/{id}")
	public CarDTO getData(@PathVariable int id) {
		CarDTO carDto=cs.getData(id);
		return carDto;
	}
	
}
