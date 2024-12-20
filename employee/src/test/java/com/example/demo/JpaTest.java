package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class JpaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getthis")  // Ensure this matches the actual endpoint in EmployeeController
                        .accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andReturn();
    }
}
