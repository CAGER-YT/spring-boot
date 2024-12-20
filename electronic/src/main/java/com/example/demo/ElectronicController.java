package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElectronicController {
	@Autowired
	ElectronicService es;
	
	@PostMapping("/save")
	public Electronic saveE(@RequestBody Electronic e) throws InvalidProduct {
		return es.saveE(e);
	}
	@PostMapping("/saveelectronic")
	public String saveElectronic(@RequestBody List<Electronic> e) {
		return es.saveElectronic(e);
	}
	@GetMapping("/getall")
	public List<Electronic> getdata(){
		return es.getdata();
	}
	@PutMapping("/updateelectronic/{id}")
	public String updateeletronic(@PathVariable int id,@RequestBody Electronic e) {
		return es.updateeletronic(id, e);
	}
	@GetMapping("/sortby/{year}")
	public List<Electronic> sortdata(@PathVariable int year){
		return es.sortdata(year);
	}
	@PostMapping("/exceptionadd")
	public String getExceptionAdd(@RequestBody Electronic e)throws ProductNotFound {
			return es.getExceptionAdd(e);
	}
	@PostMapping("/deleletronic/{num}")
	public String delemp(@PathVariable int num) {
		return es.delemp(num);
	}
	@GetMapping("/geteletronic/{num}")
	public Electronic getEl(@PathVariable int num)throws ProductNotFound {
		return es.getEl(num);
	}


}