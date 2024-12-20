package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GstService {

	@Autowired
	GstDao gd;
	public String saveall(List<Gst> e) {
		return gd.saveall(e);
	}
	public int getByHsn(int hsn) {
		return gd.getByHsn(hsn);
	}
}
