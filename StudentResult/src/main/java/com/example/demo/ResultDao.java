package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public class ResultDao {
	
	@Autowired
	ResultRepository rr;
	
	public String savedata(List<Result> r) {
		rr.saveAll(r);
		return "test";
	}
	
	public List<Result> getresult(List<Result> details){
		return rr.saveAll(details);
	}
	public List<Result>findall(){
		return rr.findAll();
	}
//	public List<Result> betweenpercentage() {
//		return rr.findAll();
//	}
	
	public Result gettopper() {
		return rr.gettopper();
	}

}
