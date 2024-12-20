
package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletResponse;
@RestController
public class HomeController {
	@Autowired
	RestTemplate r;
	@GetMapping("/getProductPage")
	public String getProduct() {
		String x=r.getForObject("http://localhost:8081/getProduct", String.class);
		return x;
	}
	@GetMapping("/getName/{name}")
	public String getFirstName(@PathVariable String name) {
		String x=r.getForObject("http://localhost:8081/getLastName", String.class);
		return name.concat(x);
	}
	@GetMapping("/getNum/{a}/{b}")
	public int getsum(@PathVariable int a,@PathVariable int b) {
		int x=r.getForObject("http://localhost:8081/getnewnum/"+b, Integer.class);
		return a+x;
	}
	@GetMapping("/getSum/{a}/{b}")
	public int getnum(@PathVariable int a,@PathVariable int b) {
		int x=r.getForObject("http://localhost:8081/getnumsum/"+a+"/"+b, Integer.class);
		return x;
	}
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.LENGTH_REQUIRED);
	}
	
	
	
	@GetMapping("/manual")
	void manual(HttpServletResponse response) throws IOException {
	    response.setHeader("test","foo");
	    response.getWriter().println("Hello World!");
	    ResponseEntity.status(202).body("new test");
	}

	@Value("${testname}")

	@GetMapping("/getBaseUrl")
	public ResponseEntity<Object> method() {
	    boolean b = true; // Your logic here
	    if (b) {
	        // If condition is true, return HTTP status code 200 (OK)
//	    	response.setHeader("Custom-Header", "foo");
	        return ResponseEntity.ok().build();
	    } else {
	        // If condition is false, return HTTP status code 409 (Conflict)
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    }
	}

	
}
