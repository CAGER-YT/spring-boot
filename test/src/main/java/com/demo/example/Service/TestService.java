package com.demo.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.Dao.TestDao;

@Service
public class TestService {
	
	@Autowired
	TestDao td;
	
	public String getMethodName() {
		return td.getMethodName();
	}

}
