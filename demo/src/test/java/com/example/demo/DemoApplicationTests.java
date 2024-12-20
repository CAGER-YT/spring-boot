package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate r;
    SampleTest s=new SampleTest();
    	
    @Before
    void testMessage2() {
        System.out.println("Before Test");
    }
    @Test
    @DisplayName("Test case 1")
    void testMessage1() {
        assertEquals("Hello World","Hello World");
    }
    
    @Test
    @DisplayName("Test case 2")
    void testMessage() {
        String message = r.getForObject("/getthis", String.class);
        assertEquals("Hello World", message);
    }
}
