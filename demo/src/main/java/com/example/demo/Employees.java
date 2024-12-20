package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employees {
//	@GetMapping("/getemployee")
//	public List<Employee get(@RequestBody Employee e){
//		return (List<Employee>) e;
//
//	}
	@GetMapping("/getemployee")
	public List<Employee> get(@RequestBody List<Employee> e){
		return e;

	}
	@GetMapping("gethigh/{salary}")
	public List<Employee> gethigh(@RequestBody List<Employee> e,@PathVariable int salary){
		List<Employee>y=new ArrayList<>();
		for(Employee x:e) {
			if(x.getSalary()==salary) {
				y.add(x);
			}
		}
		return y;
	}
	@GetMapping("gethigh1/{salary}")
	public List<Employee> gethigh1(@RequestBody List<Employee> e,@PathVariable int salary){
		List<Employee> y=e.stream().filter(x->x.getSalary()==5000).collect(Collectors.toList());
		return y;
	}
}
