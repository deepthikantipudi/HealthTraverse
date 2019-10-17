package com.miraclesoft.io.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PATIENT_MEDICAL_CONDITIONS")
public class MedicalConditions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	
	@Column(name="PID")
	private long pid;
	

	@Column(name="CONDITIONTYPE_ID")
	private long CONDITIONTYPE_ID;
	
//	@ManyToOne(targetEntity = Patient.class)
//	@JoinColumn(name="PID")
//	@NotNull
//	private Patient patient;
	
	
//	@OneToOne(targetEntity = HealthCare.class)
//	@JoinColumn(name="CONDITIONTYPE_ID")
//	@NotNull
//    private HealthCare healthCare;
	
	
	@Column(name="DIAGNOSIS_DATE")
	
	private Date diagnosisDate;

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

	public long getCONDITIONTYPE_ID() {
		return CONDITIONTYPE_ID;
	}

	public void setCONDITIONTYPE_ID(long cONDITIONTYPE_ID) {
		CONDITIONTYPE_ID = cONDITIONTYPE_ID;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	@Override
	public String toString() {
		return "MedicalConditions [id=" + id + ", pid=" + pid + ", CONDITIONTYPE_ID=" + CONDITIONTYPE_ID
				+ ", diagnosisDate=" + diagnosisDate + "]";
	}

	public MedicalConditions(long id, long pid, long cONDITIONTYPE_ID, Date diagnosisDate) {
		super();
		this.id = id;
		this.pid = pid;
		CONDITIONTYPE_ID = cONDITIONTYPE_ID;
		this.diagnosisDate = diagnosisDate;
	}

	public MedicalConditions() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	


}
