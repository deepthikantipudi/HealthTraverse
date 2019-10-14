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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="INSURANCE_ID")
	private int insuranceId;
	@Column(name="PID")
	@NotNull
	private long pId;
	@Column(name="MEDICAL_DEDUCTABLE")
	@NotNull
	private long medicalDeductable;
	@Column(name="DENTAL_DEDUCTABLE")
	@NotNull
	private long dentalDeductable;
	@Column(name="PRES_DEDUCTABLE")
	@NotNull
	private long presDeductable;
//	@Column(name="DATE")
//	@NotNull
//	private String date;
//	
	@Column(name="COVERAGE")
	private long coverage;
	
	@Column(name="MONTHLY_RATE")
	private long monthlyRate;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public long getMedicalDeductable() {
		return medicalDeductable;
	}

	public void setMedicalDeductable(int medicalDeductable) {
		this.medicalDeductable = medicalDeductable;
	}

	public long getDentalDeductable() {
		return dentalDeductable;
	}

	public void setDentalDeductable(int dentalDeductable) {
		this.dentalDeductable = dentalDeductable;
	}

	public long getPresDeductable() {
		return presDeductable;
	}

	public void setPresDeductable(int presDeductable) {
		this.presDeductable = presDeductable;
	}

	public long getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}

	public long getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(int monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientInsurancePlan other = (PatientInsurancePlan) obj;
		if (coverage != other.coverage)
			return false;
		if (dentalDeductable != other.dentalDeductable)
			return false;
		if (insuranceId != other.insuranceId)
			return false;
		if (medicalDeductable != other.medicalDeductable)
			return false;
		if (monthlyRate != other.monthlyRate)
			return false;
		if (pId != other.pId)
			return false;
		if (presDeductable != other.presDeductable)
			return false;
		return true;
	}

	public PatientInsurancePlan(int insuranceId, @NotNull int pId, @NotNull int medicalDeductable,
			@NotNull int dentalDeductable, @NotNull int presDeductable, int coverage, int monthlyRate) {
		super();
		this.insuranceId = insuranceId;
		this.pId = pId;
		this.medicalDeductable = medicalDeductable;
		this.dentalDeductable = dentalDeductable;
		this.presDeductable = presDeductable;
		this.coverage = coverage;
		this.monthlyRate = monthlyRate;
	}

	@Override
	public String toString() {
		return "PatientInsurancePlan [insuranceId=" + insuranceId + ", pId=" + pId + ", medicalDeductable="
				+ medicalDeductable + ", dentalDeductable=" + dentalDeductable + ", presDeductable=" + presDeductable
				+ ", coverage=" + coverage + ", monthlyRate=" + monthlyRate + "]";
	}

	public PatientInsurancePlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
