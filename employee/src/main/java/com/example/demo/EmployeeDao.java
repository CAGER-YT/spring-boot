package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	public String saveEmp(Employee e) {
		er.save(e);
		return "Emp Saved";
	}
	public String saveAll(List<Employee> e) {
		er.saveAll(e);
		return "All Emp Saved";
	}
	public Optional<Employee> getEmp(int num){
		return er.findById(num);
	}

	public List<Employee> getAges(int age){
		return er.getAges(age);
	}

	public Employee getByName(String p) {
	    return er.getByName(p);
	}
	public List<Employee> getAllEmp(){
		return er.findAll();
	}
	public String delemp(int num) {
		er.deleteById(num);
		return "Employee Removed";
	}
	public String delallemp() {
		er.deleteAll();
		return "All Employee Deleted";
	}
	public String change(int id,Employee e) {
		Employee x=er.findById(id).get();
		x.setName(e.getName());
		x.setSalary(e.getSalary());
		er.save(x);
		return "Updated Successfully";
	}
	public List<Employee> getMax() {
		return er.findAll();
	}
	public List<Employee> getlowestsalry() {
		return er.findAll();
	}
	public List<Employee> getEmpTaxPayable() {
		return er.findAll();
	}
	public List<Employee> getString() {
		return er.findAll();
	}
	public String patchData(int id,Employee e) {
		Employee x=er.findById(id).get();
		x.setName(e.getName());
		x.setSalary(e.getSalary());
		er.save(x);
		return "Updated";
		
	}
}
