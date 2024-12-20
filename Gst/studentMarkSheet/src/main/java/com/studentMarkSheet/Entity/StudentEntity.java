package com.studentMarkSheet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="/mark_sheet")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rollNumber;
	private int sem1theory;
	private int sem1practicals;
	private int sem2thory;
	private int sem2practicals;
	private int sem1Total;
	private int sem2Total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getSem1theory() {
		return sem1theory;
	}
	public void setSem1theory(int sem1theory) {
		this.sem1theory = sem1theory;
	}
	public int getSem1practicals() {
		return sem1practicals;
	}
	public void setSem1practicals(int sem1practicals) {
		this.sem1practicals = sem1practicals;
	}
	public int getSem2thory() {
		return sem2thory;
	}
	public void setSem2thory(int sem2thory) {
		this.sem2thory = sem2thory;
	}
	public int getSem2practicals() {
		return sem2practicals;
	}
	public void setSem2practicals(int sem2practicals) {
		this.sem2practicals = sem2practicals;
	}
	public int getSem1Total() {
		return sem1Total;
	}
	public void setSem1Total(int sem1Total) {
		this.sem1Total = sem1Total;
	}
	public int getSem2Total() {
		return sem2Total;
	}
	public void setSem2Total(int sem2Total) {
		this.sem2Total = sem2Total;
	}
	

}
