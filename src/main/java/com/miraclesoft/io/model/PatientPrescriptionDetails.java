package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_PRESCRIPTION_DETAILS")
public class PatientPrescriptionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PPDID")
	private int ppdid;
	
	@Column(name="PID")
	private long pid;
	
	
	@Column(name="PRESID")
	private int presID;
	
	
	@Column(name="MEDID")
	private int medid;
	
	@Column(name="DOSAGE")
	private String dosage;
	
	
	@Column(name="MEDI_INSTRUCTIONS")
	private String mediInstructions;


	public String getDosage() {
		return dosage;
	}


	public void setDosage(String dosage) {
		this.dosage = dosage;
	}


	public int getPpdid() {
		return ppdid;
	}


	public void setPpdid(int ppdid) {
		this.ppdid = ppdid;
	}


	public long getPid() {
		return pid;
	}


	public void setPid(long pid) {
		this.pid = pid;
	}


	public int getPresID() {
		return presID;
	}


	public void setPresID(int presID) {
		this.presID = presID;
	}


	public int getMedid() {
		return medid;
	}


	public void setMedid(int medid) {
		this.medid = medid;
	}


	public String getMediInstructions() {
		return mediInstructions;
	}


	public void setMediInstructions(String mediInstructions) {
		this.mediInstructions = mediInstructions;
	}


	@Override
	public String toString() {
		return "PatientPrescriptionDetails [ppdid=" + ppdid + ", pid=" + pid + ", presID=" + presID + ", medid=" + medid
				+ ", dosage=" + dosage + ", mediInstructions=" + mediInstructions + "]";
	}


	public PatientPrescriptionDetails(int ppdid, long pid, int presID, int medid, String dosage, String mediInstructions) {
		super();
		this.ppdid = ppdid;
		this.pid = pid;
		this.presID = presID;
		this.medid = medid;
		this.dosage = dosage;
		this.mediInstructions = mediInstructions;
	}


	public PatientPrescriptionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
