package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class Product1Dao {
@Autowired
Product1Repository pr;
	public String saveall(List<Product1> e) {
		pr.saveAll(e);
		return "Saved all";
	}
	public List<Product1> getall() {
		List<Product1> x=pr.findAll();
		return x;
	}
	public List<Object> getall1(String field) {
		return pr.getall1(field);
	}

	public String pathData(int id, Product1 p) {
	    Product1 x = pr.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));

	    if (p.getName() != null) {
	        x.setName(p.getName());
	    }
	    if (p.getHsn() != 0) {
	        x.setHsn(p.getHsn());
	    }
	    if (p.getPrice() != 0) {
	        x.setPrice(p.getPrice());
	    }
	    if (p.getQty() != 0) {
	        x.setQty(p.getQty());
	    }

	    pr.save(x);
	    return "Updated Successfully";
	}


}
