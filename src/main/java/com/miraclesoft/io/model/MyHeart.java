package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Myheart")
public class MyHeart {
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private long heartRate;
	@Column
	private long steps;
	@Column
	private long miles;
	
	public MyHeart() {
		
	}
	
	public MyHeart(long id, long heartRate, long steps, long miles) {
		super();
		this.id = id;
		this.heartRate = heartRate;
		this.steps = steps;
		this.miles = miles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(long heartRate) {
		this.heartRate = heartRate;
	}
	public long getSteps() {
		return steps;
	}
	public void setSteps(long steps) {
		this.steps = steps;
	}
	public long getMiles() {
		return miles;
	}
	public void setMiles(long miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "MyHeart [id=" + id + ", heartRate=" + heartRate + ", steps=" + steps + ", miles=" + miles + "]";
	}
	
	
	

}
