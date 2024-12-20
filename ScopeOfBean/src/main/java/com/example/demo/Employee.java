package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component
public class Employee {
	private String name;
	
	public Employee() {
		System.out.println("Bean is Created");
	}
	@Value("Santhosh")
	public void setName(String n) {
		name=n;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	
	
	

}
