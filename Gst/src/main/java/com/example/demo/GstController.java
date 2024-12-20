package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GstController {

	@Autowired
	GstService gs;
	@GetMapping("/saveall")
	public String saveall(@RequestBody List<Gst> e) {
		return gs.saveall(e);
	}
	@GetMapping("/getbyhsn/{hsn}")
	public int getByHsn(@PathVariable int hsn) {
		return gs.getByHsn(hsn);
	}
}
