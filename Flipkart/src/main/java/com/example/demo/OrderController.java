package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@PostMapping("/save")
	public String postData(@RequestBody OrderEntity o) {
		
		return os.postData(o);
	}
	@PostMapping("/saveall")
	public String postallData(@RequestBody List<OrderEntity>o) {
		
		return os.postallData(o);
	}
	@GetMapping("/getall")
	public List<Object> getData() {
		return os.getData();
	}
	
	
	

}
