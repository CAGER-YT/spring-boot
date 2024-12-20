package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Security;

public interface SpringSecurityRepository extends JpaRepository<Security, Integer>{

	
}
