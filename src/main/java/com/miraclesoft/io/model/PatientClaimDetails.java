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
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CLAIM_ID")
	private int claimId;
	@Column(name="PID")
	@NotNull
	//@Size(min=2, message="pId should have atleast 2 digits")
	private int pId;
	@Column(name="PHY_ID")
	@NotNull
//	@NotBlank(message="PhyID is mandatory")
	private int phyId;
	@Column(name="TOTAL_AMOUNT")
	@NotNull
//	@NotBlank(message="Total amount is mandatory")
	private int totalAmount;
	@Column(name="PAID_AMOUNT")
	@NotNull
//	@NotBlank(message="Paid amount is mandatory")
	private int paidAmount;
	@Column(name="DATE")
	@NotNull
	@NotEmpty
//	@NotBlank(message="Date is mandatory")
	private String date;
	@Column(name="HOSPITAL")
	@NotNull
	@Size(min=2, message="pId should have atleast 2 digits")
//	@NotBlank(message="Hospital is mandatory")
	private String hospital;


	public PatientClaimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PatientClaimDetails [claimId=" + claimId + ", pId=" + pId + ", phyId=" + phyId + ", totalAmount="
				+ totalAmount + ", paidAmount=" + paidAmount + ", date=" + date + ", hospital=" + hospital + "]";
	}

	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getpId() {
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
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPaidAmount() {
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
	
	
}
