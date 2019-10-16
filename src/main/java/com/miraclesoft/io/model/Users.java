package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "FIRST_NAME")
	private String fname;
	

	@Column(name = "LAST_NAME")
	private String lname;


//	private String mode;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLES")
	private String roles;
	
	
	

	public String getPassword() {
		return password;
	}

	public void setPassowrd(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
//
//	public String getMode() {
//		return mode;
//	}
//
//	public void setMode(String mode) {
//		this.mode = mode;
//	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

