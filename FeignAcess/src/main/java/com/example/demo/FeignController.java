package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignAc feignClient;

    @GetMapping("/hello/{a}")
    public String get(@PathVariable("a") int a) {
        return feignClient.getHi(a);
    }
	
}
