package com.miraclesoft.io.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="healthcare")
@Table(name="HEALTHCARE")      //,schema = "targetSchemaName"
public class HealthCare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CONDITIONTYPE_ID")
	private Long conditionTypeId;
	
//	@OneToOne
//	@JsonIgnore
//	private MedicalConditions medicalConditions;
	
	@Column(name="LINK_TO_API")
	@NotNull
	@NotEmpty
	private String linkToApi;
	
	@Column(name="IMAGE_LINK" , columnDefinition = "LONGBLOB")
	@NotNull
	@NotEmpty
	@Lob
	private byte[] image;
	
	@Column(name = "SEVERITY")
	private String severity;
	@Column(name = "CONDITION_NAME")
	private String conditionName;
	@Column(name = "TRIGGERS")
	private String triggers;
	
	
	
	public HealthCare() {
		
	}
	


	


	public HealthCare(Long conditionTypeId, @NotNull @NotEmpty String linkToApi, @NotNull @NotEmpty byte[] image,
			String severity, String conditionName, String triggers) {
		super();
		this.conditionTypeId = conditionTypeId;
		this.linkToApi = linkToApi;
		this.image = image;
		this.severity = severity;
		this.conditionName = conditionName;
		this.triggers = triggers;
	}






	public String getSeverity() {
		return severity;
	}






	public void setSeverity(String severity) {
		this.severity = severity;
	}






	public String getTriggers() {
		return triggers;
	}






	public void setTriggers(String triggers) {
		this.triggers = triggers;
	}






	public String getConditionName() {
		return conditionName;
	}



	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
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

	public @NotNull @NotEmpty @NotNull @NotEmpty byte[] getImage() {
		return image;
	}

	public void setImage(@NotNull @NotEmpty @NotNull @NotEmpty byte[] image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "HealthCare [conditionTypeId=" + conditionTypeId + ", linkToApi=" + linkToApi + ", image="
				+ Arrays.toString(image) + "]";
	}


	

	
}
