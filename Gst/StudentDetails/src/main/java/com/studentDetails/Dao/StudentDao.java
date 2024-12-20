package com.studentDetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentDetails.entity.Student;
import com.studentDetails.repository.studentRepository;

@Repository
public class StudentDao {
	@Autowired
	studentRepository sr;
	
	
	public List<Student> createAllStudent(List<Student> s) {
		return sr.saveAll(s);
	}


	public List<Student> getAllStudent() {
		return sr.findAll();
	}


	public String deleteAllStudents() {
		 sr.deleteAll();
		 return "Deleted all details";
	}


	public String updateById(int a, Student s) {
		Student s1=sr.findById(a).get();
		s1.setName(s.getName());
		sr.save(s1);
		return "Updated";
	}


	public String handleException(Student a) {
		sr.save(a);
		return "Successfully saved";
	}

}
