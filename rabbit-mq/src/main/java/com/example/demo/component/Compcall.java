package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;

public class Compcall {

	@Autowired
	private Compot c;
	public String a() {
		c.setA("tses");
		String b=c.getA();
		System.out.println(b);
		return b;
		
	}
	public static void main(String[] args) {
		
	

	}
}
