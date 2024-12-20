package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UseProduct2Application {

	public static void main(String[] args) {
		SpringApplication.run(UseProduct2Application.class, args);
	}
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}
