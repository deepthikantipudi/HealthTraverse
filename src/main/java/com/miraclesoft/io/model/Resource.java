package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Resource {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_id")
	Long Id;
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@NotNull @Size(min = 5, max = 20, message = "Name should be between 2 and 20 characters") 
	
	public Resource(Long id,
		String name) {
		super();
		Id = id;
		this.name = name;
	}

	@NotNull
//	@Size(min=5, max = 20, message="Name should be between 2 and 20 characters")
	String name;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
