package com.miraclesoft.io.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@NotNull
//	@Size(min=2, message="text should have atleast 2 characters")
	String text;
	
	LocalDateTime start;
	
	LocalDateTime end;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "resource_id"))
	@Column(name="resource_id")
	long resource_id;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
public Event(Long id, @NotNull String text, LocalDateTime start, LocalDateTime end, long resource_id) {
		super();
		this.id = id;
		this.text = text;
		this.start = start;
		this.end = end;
		this.resource_id = resource_id;
	}
	//	@NotNull @Size(min = 2, message = "text should have atleast 2 characters")
	public Event(String text,
			LocalDateTime start, LocalDateTime end, long resource_id) {
		super();
		this.text = text;
		this.start = start;
		this.end = end;
		this.resource_id = resource_id;
	}

	public long getResource_id() {
		return resource_id;
	}

	public void setResource_id(long resource_id) {
		this.resource_id = resource_id;
	}

//	@ManyToOne
//	@JsonIgnore
//	Resource resource;
	
//	@JsonProperty("resource")
//	public Long getResourceId() {
//		return resource.getId();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

//	public Resource getResource() {
//		return resource;
//	}
//
//	public void setResource(Resource resource) {
//		this.resource = resource;
//	}
	
	
}
