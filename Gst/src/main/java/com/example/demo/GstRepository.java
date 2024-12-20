package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GstRepository extends JpaRepository<Gst, Integer>{
	
	@Query(value = "select taxpercentage from gst where hsn=?",nativeQuery = true)
	public int getByHsn(int hsn);
}
