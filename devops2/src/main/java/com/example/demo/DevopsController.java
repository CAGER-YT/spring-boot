package com.example.demo;

import java.sql.Time;
import java.util.TimeZone;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevopsController {

	@Scheduled(cron="* * 1 * * *")
	@GetMapping("/path")
	public String getString() {
		long sm= System.currentTimeMillis();
		TimeZone a=TimeZone.getDefault();
		System.out.println("Test" + a);
		return "Hello Developer";
	}
	
}
