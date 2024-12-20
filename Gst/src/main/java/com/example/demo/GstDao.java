package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class GstDao {
	@Autowired
	GstRepository gr;
	public String saveall(List<Gst> e) {
		gr.saveAll(e);
		return "Saved all";
	}
	public int getByHsn(int hsn) {
		return gr.getByHsn(hsn);
	}

}
