package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200/")
public class EmployeeController {

	@Autowired
	EmployeeRepository er;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee e) {
//	    if (e.getAge() < 18) {
//	        throw new InvalidAgeException("Age must be 18 or older.");
//	    }
	    return er.save(e);
	}


	@GetMapping("/get/{id}")
	public Employee postMethodName(@PathVariable int id) {
		return er.findById(id).get();
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteMethodName(@PathVariable int id) {
			er.deleteById(id);
			return er.findAll();
	}
	
	@PutMapping("update/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee e) {
        return er.findById(id)
                 .map(existingEmployee -> {
                     existingEmployee.setName(e.getName());
                     existingEmployee.setAge(e.getAge());
                     existingEmployee.setGender(e.getGender());
                     existingEmployee.setSalary(e.getSalary());
                     return er.save(existingEmployee);
                 })
                 .orElseThrow();
    }
	
	@GetMapping("/getall")
	public List<Employee> getMethodList() {
		return er.findAll();
	}
	
}
