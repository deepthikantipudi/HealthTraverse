package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PATIENT_CLAIM_DETAILS")
public class PatientClaimDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLAIM_ID")
	private long claimId;
	@Column(name="PID")
	@NotNull
	//@Size(min=2, message="pId should have atleast 2 digits")
	private long pId;
	@Column(name="PHY_ID")
	@NotNull
//	@NotBlank(message="PhyID is mandatory")
	private int phyId;
	@Column(name="TOTAL_BILL_AMOUNT")
	@NotNull
//	@NotBlank(message="Total amount is mandatory")
	private long totalAmount;
	@Column(name="AMOUNT_PAID")
	@NotNull
//	@NotBlank(message="Paid amount is mandatory")
	private long paidAmount;
	@Column(name="DATE_PAID")
	@NotNull
	@NotEmpty
//	@NotBlank(message="Date is mandatory")
	private String date;
	@Column(name="HOSPITAL")
//	@NotNull
//	@Size(min=2, message="pId should have atleast 2 digits")
//	@NotBlank(message="Hospital is mandatory")
	private String hospital;

	@Column(name="COVERAGE")
//	@NotNull
//	@NotBlank(message="Paid amount is mandatory")
	private long coverage;
	
	@Column(name="CLAIM_TYPE")
//	@NotNull
//	@Size(min=2, message="pId should have atleast 2 digits")
//	@NotBlank(message="Hospital is mandatory")
	private String claimType;

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getPhyId() {
		return phyId;
	}

	public void setPhyId(int phyId) {
		this.phyId = phyId;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public long getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Override
	public String toString() {
		return "PatientClaimDetails [claimId=" + claimId + ", pId=" + pId + ", phyId=" + phyId + ", totalAmount="
				+ totalAmount + ", paidAmount=" + paidAmount + ", date=" + date + ", hospital=" + hospital
				+ ", coverage=" + coverage + ", claimType=" + claimType + "]";
	}

	public PatientClaimDetails(int claimId, @NotNull int pId, @NotNull int phyId, @NotNull int totalAmount,
			@NotNull int paidAmount, @NotNull @NotEmpty String date, String hospital, int coverage, String claimType) {
		super();
		this.claimId = claimId;
		this.pId = pId;
		this.phyId = phyId;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.date = date;
		this.hospital = hospital;
		this.coverage = coverage;
		this.claimType = claimType;
	}

	public PatientClaimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
