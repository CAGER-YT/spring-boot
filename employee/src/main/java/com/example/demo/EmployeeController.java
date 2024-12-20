package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@Autowired
EmployeeService es;

@GetMapping("/stringtest")
public String getStringtest(){
	return "hello";
}
@PostMapping("/newemp")
public String save(@RequestBody Employee e) {
	return es.saveEmp(e);
}
@GetMapping("/getemp/{num}")
public Optional<Employee> getEmp(@PathVariable int num) {
	return es.getEmp(num);
}
@PostMapping("/saveallemp")
public String saveAll(@RequestBody List<Employee> e) {
	return es.saveAll(e);
}
@GetMapping("/getempall")
public List<Employee> getAllEmp() {
	return es.getAllEmp();
}
@PostMapping("/delemp/{num}")
public String delemp(@PathVariable int num) {
	return es.delemp(num);
}
@PostMapping("delall")
public String delallemp() {
	return es.delallemp();
}
@PutMapping("/updateemp/{id}")
public String change(@PathVariable int id,@RequestBody Employee e) {
		return es.change(id,e);
	}
@GetMapping("/getMax")
public List<Employee> getMax() {
	return es.getMax();
}
@GetMapping("/lastthreesalary")
public List<Employee> getlowestsalry() {
	return es.getlowestsalry();
}
@GetMapping("/gettax")
public List<Employee> getEmpTaxPayable() {
	return es.getEmpTaxPayable();
}
@GetMapping("/getString")
public List<Employee> getString() {
	return es.getString();
}
@GetMapping("/getbyname")
public Employee getByName(@PathVariable String p) {
    return es.getByName(p);
}
@GetMapping("/getAge/{age}")
public List<Employee> getAges(@PathVariable int age){
	return es.getAges(age);
}
@PatchMapping("/getemppatch/{id}")
public String patchData(@PathVariable int id,@RequestBody Employee e) {
	return es.patchData(id, e);
	
}
}
