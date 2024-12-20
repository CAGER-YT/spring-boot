package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class Myconfiguration extends WebSecurityConfigurerAdapter{
	
//	authentication
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
////		auth.inMemoryAuthentication().withUser("sandy").password("santhosh").roles("student");
//		auth.inMemoryAuthentication().withUser("sandy").password("$2a$12$MAAd.GpZRgY.rhkhizj/TOE4Sg8xFROdKkJs/mbKN.wmEoxJ5D2ui").roles("student");
//
//		
//	}
//	
//	@Bean
//	public PasswordEncoder getpass() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	public PasswordEncoder getpass() {
//	return new BCryptPasswordEncoder(12);
//}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("sandy").password("$2a$12$MAAd.GpZRgY.rhkhizj/TOE4Sg8xFROdKkJs/mbKN.wmEoxJ5D2ui").roles("student").and()
		.withUser("manoj").password("$2a$12$5HKXMGYyALL7zgkhrHjU9eFUjU3Z14FNYzXsaxsx4cDV6NvkcZ2LC").roles("admin").and()
		.withUser("sathish").password("$2a$12$Y3FtAuWI/D9LHOurMSq25OG1A24INnHqPXw.DZKf/7QJOg2D5tL1q").roles("staff");

		
	}
	@Bean
	public PasswordEncoder getpass() {
	return new BCryptPasswordEncoder(12);
}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.authorizeRequests().antMatchers("/staff").hasAnyRole("staff","admin");
		http.authorizeRequests().antMatchers("/admin").hasRole("staff");
		http.authorizeRequests().antMatchers("/student").permitAll().and().formLogin();

	}
}
