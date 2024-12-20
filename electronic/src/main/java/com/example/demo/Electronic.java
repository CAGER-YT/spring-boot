package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Create Electronics Project, in that create Entity, Controller, Service and Repo for Fridge Object. 
//Take variables as id, brand, price, modelYear, noOfDoors. * POST 10 data in DB. * GET all the data from DB. 
//* UPADATE the 3th id's details. *DELETE the 10th id. * GET BY ID - 7th id's data only.
//GET BY Model year - if I pass 2023 in path, it must return all the 2023 model fridges.
//In same Electronics project Post a single data, if the price of the fridge is greater than 
//4lakh then thrown an Exception as PriceException, else store the data in the DB.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="electronic")
public class Electronic{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String brand;
	@NotNull
	private int price;
	private int modelYear;
	private int noOfDoors;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public int getNoOfDoors() {
		return noOfDoors;
	}
	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}
	public String PriceException() {
		return "Price is high";
	}
	
}
class PriceException extends RuntimeException{
	
	public PriceException(String a) {
		super(a);
	}
}
