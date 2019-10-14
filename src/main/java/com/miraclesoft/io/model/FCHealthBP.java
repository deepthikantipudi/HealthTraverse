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

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
@Entity
@Table(name="FCHEALTH_BP")
public class FCHealthBP {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	private long pid;
	
	@JsonIgnore
	@Column(name="BP_DATE")
	private Date bpDate;
	
	@Column(name="HBP")
	private long highBP;
	
	@Column(name="LBP")
	private long lowBP;

	

	public FCHealthBP() {
		super();
	}



	public FCHealthBP(long id, long pid, Date bpDate, long highBP, long lowBP) {
		super();
		this.id = id;
		this.pid = pid;
		this.bpDate = bpDate;
		this.highBP = highBP;
		this.lowBP = lowBP;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getPid() {
		return pid;
	}



	public void setPid(long pid) {
		this.pid = pid;
	}



	public Date getBpDate() {
		return bpDate;
	}



	public void setBpDate(Date bpDate) {
		this.bpDate = bpDate;
	}



	public long getHighBP() {
		return highBP;
	}



	public void setHighBP(long highBP) {
		this.highBP = highBP;
	}



	public long getLowBP() {
		return lowBP;
	}



	public void setLowBP(long lowBP) {
		this.lowBP = lowBP;
	}



	@Override
	public String toString() {
		return "FCHealthBP [id=" + id + ", pid=" + pid + ", bpDate=" + bpDate + ", highBP=" + highBP + ", lowBP="
				+ lowBP + "]";
	}
	
	

}
