package com.miraclesoft.io.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FCHEALTH_WEIGHT")
public class FCHealthWeight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, targetEntity=PatientProfile.class )
	//@JoinColumn(name="pid", nullable= false)
	@Column(name="PID")
	private Long pid;
	
	@Column(name="W_DATE")
	private Date weightDate;
	
	@Column(name="WEIGHT")
	private Long weight;
	
	
	
	
	public FCHealthWeight() {
		super();
	}




	public FCHealthWeight(Long id, Long pid, Date weightDate, Long weight) {
		super();
		this.id = id;
		this.pid = pid;
		this.weightDate = weightDate;
		this.weight = weight;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Long getPid() {
		return pid;
	}




	public void setPid(Long pid) {
		this.pid = pid;
	}




	public Date getWeightDate() {
		return weightDate;
	}




	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}




	public Long getWeight() {
		return weight;
	}




	public void setWeight(Long weight) {
		this.weight = weight;
	}




	@Override
	public String toString() {
		return "FCHealthWeight [id=" + id + ", pid=" + pid + ", weightDate=" + weightDate + ", weight=" + weight + "]";
	}


	
}
