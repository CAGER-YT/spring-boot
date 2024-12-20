package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="car1")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "gen")
	private int id;
	private String brand;
	private int price;
}
