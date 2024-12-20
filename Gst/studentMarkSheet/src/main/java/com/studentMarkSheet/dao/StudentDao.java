package com.studentMarkSheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentMarkSheet.Entity.StudentEntity;
import com.studentMarkSheet.repository.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	StudentRepo sr;

	public String CreateMarksheet(StudentEntity se) {
			sr.save(se);
			return "Saved Successfully";
	}

	public List<StudentEntity> getAllMarks() {
		return sr.findAll();
	}

	public Integer getByRno(int a) {
		return sr.getByRno(a);
	}

}