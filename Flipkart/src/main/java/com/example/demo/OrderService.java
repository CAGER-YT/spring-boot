package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderDao od;
	
	public String postData(OrderEntity o) {
		
		return od.postData(o);
	}
	public String postallData(List<OrderEntity>o) {
		
		return od.postallData(o);
	}
	public List<Object> getData() {
		return od.getData();
	}
}
