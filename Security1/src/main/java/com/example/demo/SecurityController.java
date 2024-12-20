package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SecurityController {

	@GetMapping("/student")
	public String getStudent() {
		return "This is Student";
	}
	@PreAuthorize("ADMIN")
	@GetMapping("/admin")
	public String getAdmin() {
		return "This is Admin";
	}
	@GetMapping("/staff")
	public String getStaff() {
		return "This is Staff";
	}
	
}
