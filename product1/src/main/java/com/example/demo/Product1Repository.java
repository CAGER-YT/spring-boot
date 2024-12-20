package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Product1Repository extends JpaRepository<Product1, Integer>{


	@Query(value = "SELECT ? FROM productschema.product;",nativeQuery = true)
	public List<Object> getall1(String field);
}
