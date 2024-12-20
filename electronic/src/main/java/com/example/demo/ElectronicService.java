package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectronicService  {
    private ElectronicDao ed;
    @Autowired
    public ElectronicService() {
        this.ed = new ElectronicDao(); // Manually instantiating the DAO
    }


    public Electronic saveE(Electronic e) throws InvalidProduct {
        if (e.getPrice() > 2000) { // Example condition for throwing an exception
            throw new InvalidProduct("Price exceeds the maximum limit.");
        }else {
        return ed.saveE(e);
        }
    }
public String saveElectronic(List<Electronic> e) {
	return ed.saveElectronic(e);
}

public List<Electronic> getdata(){
	return ed.getdata();
}

public String updateeletronic(int id,Electronic e) {
	return ed.updateeletronic(id, e);
}

public List<Electronic> sortdata(int year){
    List<Electronic> e = ed.getdata();
	List<Electronic> x=e.stream().filter(y->y.getModelYear()==year).collect(Collectors.toList());
	ed.sortdata(year);
	return x;
}
//public String getExceptionAdd(Electronic e)  {
//
//		return ed.getExceptionAdd(e);
//}
public String getExceptionAdd(Electronic e)throws ProductNotFound {

        if(e.getPrice() > 400000) {
        	throw new ProductNotFound("test");
        } else {
            return ed.getExceptionAdd(e);
        }
}
public String delemp(int num) {
	return ed.delemp(num);
}
public Electronic getEl(int num)throws ProductNotFound {
	Electronic e = ed.getEl(num);
	if(e.getBrand().equals("Sony")) {
		throw new ProductNotFound("test");
	}else {
		return e;
	}
}
}
