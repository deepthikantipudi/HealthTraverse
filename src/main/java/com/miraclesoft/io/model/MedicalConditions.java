package com.miraclesoft.io.model;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="PATIENT_MEDICAL_CONDITIONS")
public class MedicalConditions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity = PatientProfile.class)
	@JoinColumn(name="PID")
	@NotNull
	private PatientProfile patient;
	
	
	@OneToOne(targetEntity = HealthCare.class)
	@JoinColumn(name="CONDITIONTYPE_ID")
	@NotNull
    private HealthCare healthCare;
	
	
	@Column(name="DIAGNOSIS_DATE")
	@NotNull
	@NotEmpty
	private Date diagnosisDate;

	public MedicalConditions() {
		
	}

	
	public MedicalConditions(Long id, PatientProfile patient, HealthCare healthCare, Date diagnosisDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.healthCare = healthCare;
		this.diagnosisDate = diagnosisDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PatientProfile getPatient() {
		return patient;
	}

	public void setPatient(PatientProfile optional) {
		this.patient = optional;
	}

	public HealthCare getHealthCare() {
		return healthCare;
	}

	public void setHealthCare(HealthCare optional) {
		this.healthCare = optional;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}
	
	
	
	


}
