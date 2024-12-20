package com.studentMarkSheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentMarkSheet.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

	
	@Query(value="select sem1total+sem2total from /mark_sheet where rollNumber=?",nativeQuery=true)
	public Integer getByRno(int a);
	

}
