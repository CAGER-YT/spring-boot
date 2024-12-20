package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class ElectronicDao {
@Autowired
ElectronicRepository er;
public String saveElectronic(List<Electronic> e) {
	er.saveAll(e);
	return "All Data is saved";
}
public Electronic saveE(Electronic e) {
	return er.save(e);
}
public List<Electronic> getdata(){
	return er.findAll();
}
public String updateeletronic(int id,Electronic e) {
	Electronic x=er.findById(id).get();
	x.setBrand(e.getBrand());
	x.setModelYear(e.getModelYear());
	x.setNoOfDoors(e.getNoOfDoors());
	x.setPrice(e.getPrice());
	er.save(x);
	return "Updated Succeffuly";
}
public List<Electronic> sortdata(int year){
	return er.findAll();
}
public String getExceptionAdd(Electronic e) {
	er.save(e);
	return "Added Succesfuly"+e;
}
public String delemp(@PathVariable int num) {
	er.deleteById(num);
	return "Successfully Deleted";
}
public Electronic getEl(@PathVariable int num) {
	return er.findById(num).get();
}
}
