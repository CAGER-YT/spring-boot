package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class Product1Service {

	@Autowired
	Product1Dao pd;
	public String saveall(List<Product1> e) {
		return pd.saveall(e);
	}
	public List<Product1> getall() {
		return pd.getall();
	}
	public List<Object> getall1(String field) {
		return pd.getall1(field);
	}
	public String pathData(int id ,Product1 p) {
		return pd.pathData(id, p);
	}
}
