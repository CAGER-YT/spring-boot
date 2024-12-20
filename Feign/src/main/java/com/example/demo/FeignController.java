package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {

//	@GetMapping("/hi")
//	public String getHi() {
//		return "hii this is santhosh";
//	}
	
    @GetMapping("/hi/{a}")
    public String getHi(@PathVariable("a") int a) {
        return "Hello from Project B, received parameter: " + a;
    }
	
}
