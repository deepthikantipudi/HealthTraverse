package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_PROFILE")
public class PatientProfile {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="PID") 
	private long pid;
	
//	@Column(name="USER_ID")
//	private long user_id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user_id;
	
	@Column(name="RELATION")
	private String relation;
	
	@Column(name="PATIENT_NAME")
	private String patientName;
	
	@Column(name="HEIGHT")
	private long height ;
	
	@Column(name="WEIGHT")
	private long weight;

	public PatientProfile() {
		super();
	}

	public PatientProfile(long pid, Users user_id, String relation, String patientName, long height, long weight) {
		super();
		this.pid = pid;
		this.user_id = user_id;
		this.relation = relation;
		this.patientName = patientName;
		this.height = height;
		this.weight = weight;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPatient() {
		return patientName;
	}

	public void setPatient(String patientName) {
		this.patientName = patientName;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PatientProfile [pid=" + pid + ", user_id=" + user_id + ", relation=" + relation + ", patient=" + patientName
				+ ", height=" + height + ", weight=" + weight + "]";
	}


}

