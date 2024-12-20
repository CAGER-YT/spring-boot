package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OauthApplication {

	
    @GetMapping("/")
    public String message(Principal principal) {
        return "Hi " + principal.getName();
    }
	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

}
