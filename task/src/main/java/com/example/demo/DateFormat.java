package com.example.demo;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//Convert String to Date format and return it, without DB. Sample input URL – http://localhost:8080/convert/
//09 April,1999. Output: 1999-04-09. Note: “09 April,1999” is String. 
@RestController
public class DateFormat {
	@GetMapping("/date/{d}")
	public String getDate(@PathVariable String d) throws ParseException {
		SimpleDateFormat inputdate = new SimpleDateFormat("dd MMMM, yyyy");
        SimpleDateFormat outdate = new SimpleDateFormat("AAAA");
        Date date = inputdate.parse(d);
        String finaldate = outdate.format(date);
		return finaldate;
	}
}
