package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonToPojo {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException  {
		
		ObjectMapper mapper =new ObjectMapper();
		
		InputStream io=new FileInputStream("target/car.json");
		Car car=mapper.readValue(io, Car.class);
		io.close();
		
		System.out.println(car.getId());
		System.out.println(car.getBrand());
		System.out.println(car.getPrice());

	}
}
