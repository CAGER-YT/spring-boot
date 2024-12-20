package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	@Autowired
	RestTemplate r;
	
	@GetMapping("/getproduct/{field}")
	public List<Product> getAllProduct(@PathVariable String field){
		String url1="http://localhost:8080/findall/";
		
		ResponseEntity<List<Product>> response1=r.exchange(url1+field, HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>(){});
		
		List<Product> products=response1.getBody();
		
		return products;
	}
	
	
	
}
