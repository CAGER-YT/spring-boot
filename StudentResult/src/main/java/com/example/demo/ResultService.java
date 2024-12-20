package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResultService {

	@Autowired
	ResultDao rd;
	@Autowired
	RestTemplate restTemplate;
	
	public String savedata(List<Result> r) {
		return rd.savedata(r);
	}
	public List<Result>findall(){
		return rd.findall();
	}
	
	public List<Result> calculateResults() {
		String findAllUrl = "http://localhost:8080/findall"; 
		String getByRollFirstUrl = "http://localhost:8081/getbyrollfirst/";


		ResponseEntity<List<Result>> response1 = restTemplate.exchange(
			findAllUrl,
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<Result>>() {}
		);
		List<Result> details = response1.getBody();

		details.forEach(result -> {
			int roll = result.getRollnumber();

			ResponseEntity<Integer> response2 = restTemplate.exchange(
				getByRollFirstUrl + roll,
				HttpMethod.GET,
				null,
				Integer.class
			);
	
			int firstSemesterTotal = response2.getBody();
			Student s = new Student();

			int attendance = s.getAttendance();


	        if (attendance > 90) {
	            result.setTotalmarks(firstSemesterTotal + 5);
	        } else {
	            result.setTotalmarks(firstSemesterTotal);
	        }
	        result.setPercentage(((double) result.getTotalmarks() / 200) * 100);
		});

		rd.getresult(details);
		return details;
	}
	
	public List<Result> gettopper3() {
		List<Result> r=findall();
        List<Result> topThreeRankers = r.stream().sorted((r1, r2) ->Integer.compare(r2.getTotalmarks(),r1.getTotalmarks())).limit(3).collect(Collectors.toList());
        return topThreeRankers;
	}
	
	public Result gettopper() {
		return rd.gettopper();
	}
	
	public List<Result> betweenpercentage(int a,int b) {
		List<Result> r=findall();
	    List<Result> c = r.stream().filter(x->x.getPercentage()>a&&x.getPercentage()<b).collect(Collectors.toList());
		return c;
	}
	
}
