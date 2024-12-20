package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HomeConfig {
	@Bean
	public RestTemplate rest() {
		RestTemplate rt=new RestTemplate();
		return rt;
	}
}
