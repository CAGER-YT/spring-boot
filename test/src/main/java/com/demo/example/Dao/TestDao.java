package com.demo.example.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.example.Repository.TestRepository;

@Repository
public class TestDao {
	
	@Autowired
//	TestRepository tr;
	
	public String getMethodName() {
		return "This is hello world";
	}

}
