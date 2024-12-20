
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;

@RestController
public class ResultController {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ResultService rs;
	@GetMapping("/saveall")
	public String savedata(@Valid@RequestBody List<Result> r) {
		return rs.savedata(r);
	}
	@GetMapping("/getresult")
	public List<Result> getresult() {
		return rs.calculateResults();
	}
	@GetMapping("/gettopperthree")
	public List<Result> gettopper3() {
		return rs.gettopper3();
	}
	@GetMapping("/findall")
	public List<Result>findall(){
		return rs.findall();
	}
	@GetMapping("/gettooper")
	public Result gettopper() {
		return rs.gettopper();
	}
	@GetMapping("/betweenpercentage/{a}/{b}")
	public List<Result> betweenpercentage(@PathVariable int a,@PathVariable int b) {
		return rs.betweenpercentage(a,b);
	}
	

	
}

