package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	
	@Query(value = "SELECT o.pincode,p.prodname FROM product.orderlist o inner join product p on o.id=p.order_fkey;",nativeQuery = true)
	public List<Object> getData();

}
