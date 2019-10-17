package com.miraclesoft.io.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_PRESCRIPTION")
public class PatientPrescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRESID")
	private int presid;
	
	@Column(name="PID")
	private long pid;
	
	public long getPresid() {
		return presid;
	}

	public void setPresid(int presid) {
		this.presid = presid;
	}

	@Column(name="START_DATE")
	private Date START_DATE;
	
	@Column(name="END_DATE")
	private Date END_DATE;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}

	@Override
	public String toString() {
		return "PatientPrescription [pid=" + pid + ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + "]";
	}

	public PatientPrescription(long pid, Date sTART_DATE, Date eND_DATE) {
		super();
		this.pid = pid;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
	}

	public PatientPrescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
	
}
