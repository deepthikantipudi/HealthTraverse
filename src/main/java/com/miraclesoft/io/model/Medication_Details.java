package com.miraclesoft.io.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Medication_Details {

	@Id
	@GeneratedValue()
	private long MEDID;
	 @NotNull
	 @Size(min=2, message="Description should have atleast 2 characters")
	private String DESCRIPTION;
	public long getMEDID() {
		return MEDID;
	}
	public void setMEDID(long mEDID) {
		MEDID = mEDID;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Medication_Details(long mEDID, String dESCRIPTION) {
		super();
		MEDID = mEDID;
		DESCRIPTION = dESCRIPTION;
	}
	public Medication_Details() {
		super();
	}
	

}
