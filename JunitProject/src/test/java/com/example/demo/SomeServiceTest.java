package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class SomeServiceTest {

    @MockBean
    private SomeDependency someDependency;

    @Autowired
    private SomeService someService;

    @Test
    public void testServiceMethod() {
        when(someDependency.someMethod()).thenReturn("mocked value");

        String result = someService.serviceMethod();

        assertEquals("mocked value", result);
        verify(someDependency).someMethod();
    }
}
