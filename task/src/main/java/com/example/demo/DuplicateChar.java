package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Find duplicate lower case and unique character upper case in String value - combine and print it, Without DB. 
@RestController
public class DuplicateChar {

@GetMapping("/duplicate/{input}")
    public String analyzeCharacters(@PathVariable  String input) {
	Map<Character,Integer> compare=new HashMap<>();
	String temp="";
	for(char c:input.toCharArray()) {
		char lc=Character.toLowerCase(c); // converting to lower character
		if(Character.isLowerCase(c)) {
			 compare.put(lc,compare.getOrDefault(lc, 0) + 1);
		}else if (Character.isUpperCase(c) && !compare.containsKey(lc)) {
            temp=temp+c; 
        }
	}
	for (Map.Entry<Character, Integer> entry : compare.entrySet()) {
        if (entry.getValue() > 1) {
            temp =temp+entry.getKey(); 
        }
    }
	return temp;
    }
}

