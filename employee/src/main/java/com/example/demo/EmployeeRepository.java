package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "Select * from employee where name=?",nativeQuery = true)
	public Employee getByName(String p);

	@Query(value= "Select b from Employee b where b.a>:age")
	public List<Employee> getAges(@Param("age")int age);
}
