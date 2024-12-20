package com.studentDetails.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentDetails.Dao.StudentDao;
import com.studentDetails.entity.Student;
import com.studentDetails.exception.CustomException;

@Service
public class StudentService {
	@Autowired
	StudentDao sd;
	
	
	public List<Student> createAllStudent(List<Student> s) {
		return sd.createAllStudent(s);
	}


	public List<Student> getAllStudent() {
		return sd.getAllStudent();
	}


	public String deleteAllStudents() {
		return sd.deleteAllStudents();
	}


	public String updateById(int a, Student s) {
		return sd.updateById(a,s);
	}


	public String handleException(Student a) throws CustomException{
		if(a.getAge()>18) {
			return sd.handleException(a);
		}
		else {
			throw new CustomException("the age is less than 18");
		}
	
		
	}

}
