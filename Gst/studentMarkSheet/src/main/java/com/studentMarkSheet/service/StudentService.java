package com.studentMarkSheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentMarkSheet.Entity.StudentEntity;
import com.studentMarkSheet.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	StudentDao sd;

	public String CreateMarksheet(StudentEntity se) {
		int total1=se.getSem1practicals()+se.getSem1theory();
		int total2=se.getSem2practicals()+se.getSem2thory();
		se.setSem1Total(total1);
		se.setSem2Total(total2);
		return sd.CreateMarksheet(se);
				
		
	}

	public List<StudentEntity> getAllMarks() {
		return sd.getAllMarks();
	}

	public Integer getByRno(int a) {
		return sd.getByRno(a);
	}

}
