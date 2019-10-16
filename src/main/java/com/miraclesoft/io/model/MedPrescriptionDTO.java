package com.miraclesoft.io.model;

import java.util.Arrays;

import javax.persistence.Entity;


public class MedPrescriptionDTO {

	private String DESCRIPTION;
	private String MEDNAME;
	private String dosage;
	private String mediInstructions;
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getMEDNAME() {
		return MEDNAME;
	}
	public void setMEDNAME(String mEDNAME) {
		MEDNAME = mEDNAME;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getMediInstructions() {
		return mediInstructions;
	}
	public void setMediInstructions(String mediInstructions) {
		this.mediInstructions = mediInstructions;
	}
	@Override
	public String toString() {
		return "MedPrescriptionDTO [DESCRIPTION=" + DESCRIPTION + ", MEDNAME=" + MEDNAME + ", dosage=" + dosage
				+ ", mediInstructions=" + mediInstructions + "]";
	}
	public MedPrescriptionDTO(String dESCRIPTION, String mEDNAME, String dosage, String mediInstructions) {
		super();
		DESCRIPTION = dESCRIPTION;
		MEDNAME = mEDNAME;
		this.dosage = dosage;
		this.mediInstructions = mediInstructions;
	}
	public MedPrescriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
	
	
}
