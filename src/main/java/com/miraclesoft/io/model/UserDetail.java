package com.miraclesoft.io.model;

import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER_EXTENDED_DETAILS")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="AGE")
	@Min(message = "AGE min val is 10", value = 10)
	@NotNull(message = "Please provide age of the person")
	private int age;
	@Column(name="HEIGHT")
	private int height;
	@Column(name="WEIGHT")
	private int weight;
	@Column(name="GENDER")
	private String GENDER;
	@Column(name="dob")
	private String dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", userId=" + userId + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", GENDER=" + GENDER + ", dob=" + dob + "]";
	}
	public UserDetail(int id, long userId,
			@Min(message = "AGE min val is 10", value = 10) @NotNull(message = "Please provide age of the person") int age,
			int height, int weight, String gENDER, String dob) {
		super();
		this.id = id;
		this.userId = userId;
		this.age = age;
		this.height = height;
		this.weight = weight;
		GENDER = gENDER;
		this.dob = dob;
	}
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
