package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UseProductController {
	@Autowired
	RestTemplate r;
	
	@GetMapping("/getproduct")
	public List<Product> getAllProduct(){
		String url1="http://localhost:8080/findall";
		String url2="http://localhost:8081/getbyhsn/";
		
		ResponseEntity<List<Product>> response1=r.exchange(url1, HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>(){});
		
		List<Product> products=response1.getBody();
		
		products.forEach(x->{
			int hsn=x.getHsn();
			ResponseEntity<Integer> response2=r.exchange(url2+hsn, HttpMethod.GET,null,new ParameterizedTypeReference<Integer>(){});
			
			int percentage =response2.getBody();
			int taxAmount=x.getPrice()*percentage/100;
			x.setPrice(x.getPrice()+taxAmount);

		});
		return products;
	}
}
