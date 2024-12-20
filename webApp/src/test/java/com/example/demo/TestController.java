package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

public class TestController extends WebAppApplicationTests{
	
	@Autowired
	TestRestTemplate restTemplate;
	
	Calculator c=new Calculator();
	@Before
	public void startMessage() {
		System.out.println("Test Case Started");
	}
	
	@Test
	public void testAdd() {
		c.add(10, 20);
	}
	
  @Test
  public void testGetObject(){
      String m = restTemplate.getForObject("/path", String.class);
      assertEquals("Test", m);
  }

	
	@After
	public void endMessage() {
		System.out.println("Test Case Ended");
	}
}
