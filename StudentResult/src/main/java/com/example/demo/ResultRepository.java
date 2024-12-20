package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultRepository extends JpaRepository<Result, Integer>{

	@Query(value = "select * from result where totalmarks=(select max(totalmarks) from result)",nativeQuery = true)
	public Result gettopper();
}