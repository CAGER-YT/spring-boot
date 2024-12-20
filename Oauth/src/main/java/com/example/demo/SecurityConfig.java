package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> {
	            auth.requestMatchers("/").permitAll();
	            auth.anyRequest().authenticated();
	        })
	        .formLogin() // This enables the default login form
	            .defaultSuccessUrl("/", true) // Redirect to the home page after successful login
	            .permitAll() // Allow everyone to access the login page
	        .and()
	        .oauth2Login() // This enables OAuth2 login with GitHub
	            .loginPage("/login") // Use the same login page for both form login and OAuth2 login
	            .defaultSuccessUrl("/", true) // Redirect to the home page after successful OAuth2 login
	        .and()
	        .logout()
	            .logoutSuccessUrl("/") // Redirect to the home page after logout
	            .permitAll();

	    return http.build();
	}

}
