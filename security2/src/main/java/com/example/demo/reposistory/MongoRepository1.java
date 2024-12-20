package com.example.demo.reposistory;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface MongoRepository1 extends MongoRepository<Product, String>{
	
	@Query("{name:?0}")
    public Optional<Product> getProductById(String id);

}
