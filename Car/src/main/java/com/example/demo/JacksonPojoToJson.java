package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonPojoToJson {

	public static void main(String[] args) throws IOException  {
		
		ObjectMapper om=new ObjectMapper();
		
		om.enable(SerializationFeature.INDENT_OUTPUT);
		
		Car c=new Car();
		c.setId(2);
		c.setBrand("Suzuki");
		c.setPrice(2500512);
		
		String  postjson=om.writeValueAsString(c);
		
		System.out.println(postjson);
		
		
		OutputStream os=new FileOutputStream("target/car1.json");
		om.writeValue(os, c);
		os.close();
	}
}
