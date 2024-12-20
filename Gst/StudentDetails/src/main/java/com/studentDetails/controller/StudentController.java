package com.studentDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentDetails.entity.Student;
import com.studentDetails.exception.CustomException;
import com.studentDetails.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping(value="/createAllStudent")
	private List<Student> createAllStudent(@RequestBody List<Student> s){
		return ss.createAllStudent(s);
	}
	
	@GetMapping(value="/getAllStudent")
	private List<Student> getAllStudent(){
		return ss.getAllStudent();
	}
	
	@DeleteMapping(value="/deleteAllStudents")
	private String deleteAllStudents() {
		return ss.deleteAllStudents();
	}
	
	@PutMapping(value="/updateById/{a}")
	private String updateById(@PathVariable int a,@RequestBody Student s) {
		return ss.updateById(a,s);
	} 
	
	@PostMapping(value="/handleException")
	private String handleException(@RequestBody Student a) throws CustomException{
		return ss.handleException(a);
	}
}
