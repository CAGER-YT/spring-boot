package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.SpringSecurityRepository;
import com.example.demo.entity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SecurityController {

	@Autowired
	SpringSecurityRepository ssr;
	@Autowired
	PasswordEncoder pass;
	@PostMapping("/registeruser")
	public String registerUser(@RequestBody Security s) {
		//TODO: process POST request
		
		return "";
	}
	@GetMapping("/home")
	public String getHome() {
		return "Home page";
	}
	
	@GetMapping("/home")
	public String getUserHome() {
		return "";
	}
	
	@GetMapping("/home")
	public String getAdminHome() {
		return "";
	}
	
	
}
