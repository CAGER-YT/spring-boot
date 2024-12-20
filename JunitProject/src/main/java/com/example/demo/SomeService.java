package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {
    @Autowired
    private SomeDependency someDependency;

    public String serviceMethod() {
        return someDependency.someMethod();
    }
}

