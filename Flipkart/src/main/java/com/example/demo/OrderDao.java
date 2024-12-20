package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	
	@Autowired
	OrderRepository or;
	
	public String postData(OrderEntity o) {
		
		or.save(o);
		return "Saved Successfully";
	}
	public String postallData(List<OrderEntity>o) {
		
		or.saveAll(o);
		return "Save all";
	}
	public List<Object> getData() {
		return or.getData();
	}
	

}
