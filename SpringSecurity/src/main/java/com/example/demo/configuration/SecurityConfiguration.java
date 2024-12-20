package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
//	@Bean
//	SecurityFilterChain securityFilter(HttpSecurity http)throws Exception{
//		return http.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(r->r.requestMatchers("/home").permitAll());//csrf cross site resource 
//	}
}
