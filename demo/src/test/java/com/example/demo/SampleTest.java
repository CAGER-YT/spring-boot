package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = Sample.class)
public class SampleTest {
	
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test-1")
    @Test
    public void testHello() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getthis")  // Ensure this matches the actual endpoint in EmployeeController
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();
    }

    @DisplayName("Test-2")
    @Test
    public void testhelloString()throws Exception{
    	RequestBuilder s= MockMvcRequestBuilders
    			.get("/getthis")
    			.accept(MediaType.APPLICATION_JSON);
    	MvcResult result=mockMvc.perform(s)
    			.andExpect(status().isOk())
    			.andExpect(content().string("Hello World"))
    			.andReturn();
    }
    
        @Test
        public void testHelloString() throws Exception {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/getthis1")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().string("Hello World"))
                    .andReturn();
        }
    
    @DisplayName("Test-3")
    @Test
    public void testhelloString1()throws Exception{

//    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                .get("/stringtest")
//                .accept(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")) // Set character encoding
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().string("Hello World"))
//        .andReturn();
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/getthis")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Ensure correct content type
        .andExpect(content().string("Hello World"))
        .andReturn();


    }
    
}
