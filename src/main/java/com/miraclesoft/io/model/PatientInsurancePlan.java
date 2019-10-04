package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PATIENT_INSURANCE_PLAN")
public class PatientInsurancePlan {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="INS_ID")
	private int insId;
	@Column(name="PID")
	@NotNull
	private int pId;
	@Column(name="MEDICAL_DEDUCTABLE")
	@NotNull
	private int medicalDeductable;
	@Column(name="DENTAL_DEDUCTABLE")
	@NotNull
	private int dentalDeductable;
	@Column(name="PRES_DEDUCTABLE")
	@NotNull
	private int presDeductable;
	@Column(name="DATE")
	@NotNull
	@NotEmpty
	private String date;
	
	public PatientInsurancePlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientInsurancePlan [insId=" + insId + ", pId=" + pId + ", medicalDeductable=" + medicalDeductable
				+ ", dentalDeductable=" + dentalDeductable + ", presDeductable=" + presDeductable + ", date=" + date
				+ "]";
	}

	public int getInsId() {
		return insId;
	}

	public void setInsId(int insId) {
		this.insId = insId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getMedicalDeductable() {
		return medicalDeductable;
	}

	public void setMedicalDeductable(int medicalDeductable) {
		this.medicalDeductable = medicalDeductable;
	}

	public int getDentalDeductable() {
		return dentalDeductable;
	}

	public void setDentalDeductable(int dentalDeductable) {
		this.dentalDeductable = dentalDeductable;
	}

	public int getPresDeductable() {
		return presDeductable;
	}

	public void setPresDeductable(int presDeductable) {
		this.presDeductable = presDeductable;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
