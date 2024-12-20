package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {

	@GetMapping("/getProduct")
	public String get() {
		return "Product";
	}
	@GetMapping("/getLastName")
	public String getLastName() {
		return "Kumar";
	}
	@GetMapping("/getnewnum/{i}")
	public int getsum(@PathVariable int i) {
		return i*i;
	}
	@GetMapping("/getnumsum/{i}/{j}")
	public int getsum1(@PathVariable int i,@PathVariable int j) {
		return i+j;
	}
}
