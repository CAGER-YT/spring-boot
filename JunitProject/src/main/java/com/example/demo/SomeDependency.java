package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency {
    public String someMethod() {
        return "real value";
    }
}

