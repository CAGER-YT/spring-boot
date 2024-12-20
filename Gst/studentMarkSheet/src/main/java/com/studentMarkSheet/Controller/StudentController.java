package com.studentMarkSheet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentMarkSheet.Entity.StudentEntity;
import com.studentMarkSheet.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService sc;
	
	
	@PostMapping(value="/CreateMarksheet")
	public String CreateMarksheet(@RequestBody StudentEntity se) {
		return sc.CreateMarksheet(se);
	}
	@GetMapping(value="/getAllMarks")
	public List<StudentEntity> getAllMarks(){
		return sc.getAllMarks();
	}
	
	@GetMapping(value="/getByRno/{a}")
	public Integer getByRno(@PathVariable int a) {
		return sc.getByRno(a);
	}

}
