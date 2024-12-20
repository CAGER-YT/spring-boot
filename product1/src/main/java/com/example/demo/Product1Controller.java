package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product1Controller {

	@Autowired
	Product1Service ps;
	
	@GetMapping("/findall/{field}")
	public List<Object> getall1(@PathVariable String field) {
		return ps.getall1(field);
	}
	
	@GetMapping("/saveall")
	public String saveall(@RequestBody List<Product1> e) {
		return ps.saveall(e);
	}
	@GetMapping("/findall")
	public List<Product1> getall() {
		return ps.getall();
	}
	@PatchMapping("/get/{id}")
	public String pathData(@PathVariable int id ,@RequestBody Product1 p) {
		return ps.pathData(id, p);
	}
	
}

