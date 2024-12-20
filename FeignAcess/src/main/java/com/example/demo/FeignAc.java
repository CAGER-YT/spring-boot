package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "h",url = "http://localhost:8080")
public interface FeignAc {
    @GetMapping("/hi/{a}")
    String getHi(@PathVariable("a") int a);
}
