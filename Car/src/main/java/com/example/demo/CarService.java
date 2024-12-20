package com.example.demo;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepoisotory cr;
	
	@Autowired
	private ModelMapper m;
	
	public String postData(Car c) {
		//TODO: process POST request
			cr.save(c);
		return "Saved succesfully";
	}
	
//	public Car getData(int id) {
//		return cr.findById(id).get();
//	}
	public CarDTO getData(int id) {
		Optional<Car> car= cr.findById(id);
		if(car.isPresent()) {
			
//			m.map(car.get().CarDto)
		return m.map(car.get(), CarDTO.class);
		}else {
			return null;
		}
	}
}
