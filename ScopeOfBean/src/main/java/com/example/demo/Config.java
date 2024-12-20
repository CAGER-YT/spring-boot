package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	ApplicationContext ac;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1= ac.getBean(Employee.class);
		System.out.println(e1);
		Employee e2= ac.getBean(Employee.class);
		e2.setName("Manoj");
		System.out.println(e2);
		Employee e3= ac.getBean(Employee.class);
		System.out.println(e3);
		
	}

}
