package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@ResponseBody
//@Controller
@RestController
public class Sample {
	@GetMapping(value="/getthis", produces = MediaType.APPLICATION_JSON_VALUE)
    public String get() {
        return "Hello World";
    }

    @GetMapping(value="/getthis1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String get1() {
        return "Hello World";
    }
@RequestMapping("/addnum/{a}/{b}")
public int add(@PathVariable int a,@PathVariable int b) {
	return a+b;
}
@RequestMapping("/addnum1/{a}/{b}")
public int add1(@PathVariable("a") int x,@PathVariable("b") int y) {
	return x+y;
}
@GetMapping("/hello")
public String getString() {
    return "1.html";
}

//@RequestMapping("/getnumabove/{a}")
//public int getNumAbove(@PathVariable("a") int x) {
//	List<Integer>y=new ArrayList();
//	y.add(11);
	
	
//}

}
