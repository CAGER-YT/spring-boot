package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
//	@Bean
//	public SecurityFilterChain securityFilter(HttpSecurity hs) throws Exception {
////		hs.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		hs.csrf().disable().authorizeHttpRequests((auth)-> auth.anyRequest().authenticated())
//		.httpBasic(Customizer.withDefaults());
//		return hs.build();
//		
//	}

//    public static void main(String[] args) {
//        UserDetails sandy = User.withUsername("sandy")
//                                .password("{noop}sandy") // {noop} indicates no password encoding
//                                .roles("Admin")
//                                .build();
//        
//        System.out.println(sandy);
//    }
}
