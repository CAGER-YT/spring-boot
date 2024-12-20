package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pattern {
	@GetMapping("/triangle/{number}")
	public String generateTrianglePattern(@PathVariable int number) {
	    String temp = "";
	    for (int i = 1; i <= number; i++) {
	        for (int j = 1; j <= i; j++) {
	            temp += j + " ";
	        }
	        temp += "\n";
	    }
	    return temp;
	}
}
