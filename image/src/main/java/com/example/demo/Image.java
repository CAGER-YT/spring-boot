package com.example.demo;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pm_of_india")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Blob photo;
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	

}