package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="HEALTHCARE")
public class HealthCare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CONDITIONTYPE_ID")
	private Long conditionTypeId;
	
	@OneToOne
	@JsonIgnore
	private MedicalConditions medicalConditions;
	
	@Column(name="LINK_TO_API")
	@NotNull
	@NotEmpty
	private String linkToApi;
	
	@Column(name="IMAGE_LINK")
	@NotNull
	@NotEmpty
	private String imageLink;
	
	
	
	public HealthCare() {
		
	}
	

	public HealthCare(Long conditionTypeId, String linkToApi, String imageLink) {
		super();
		this.conditionTypeId = conditionTypeId;
		this.linkToApi = linkToApi;
		this.imageLink = imageLink;
		
	}

	public Long getConditionTypeId() {
		return conditionTypeId;
	}

	public void setConditionTypeId(Long conditionTypeId) {
		this.conditionTypeId = conditionTypeId;
	}

	public String getLinkToApi() {
		return linkToApi;
	}

	public void setLinkToApi(String linkToApi) {
		this.linkToApi = linkToApi;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	
	
	
	
}
