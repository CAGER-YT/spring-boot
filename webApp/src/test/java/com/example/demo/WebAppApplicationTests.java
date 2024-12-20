package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebAppApplicationTests {

	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
	}

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
