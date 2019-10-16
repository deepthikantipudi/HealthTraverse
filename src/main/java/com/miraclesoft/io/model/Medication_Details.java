package com.miraclesoft.io.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Medication_Details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEDID")
	private int MEDID;
	// @NotNull
	 //@Size(min=2, message="Description should have atleast 2 characters")
	@Column(name="DESCRIPTION")
	private String DESCRIPTION;
	
	@Column(name="MEDNAME")
	private String MEDNAME;
	
	@Column(name="MEDIMAGE")
	private byte[] MEDIMAGE;

	public int getMEDID() {
		return MEDID;
	}

	public void setMEDID(int mEDID) {
		MEDID = mEDID;
	}

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

	public byte[] getMedImage() {
		return MEDIMAGE;
	}

	public void setMedImage(byte[] medImage) {
		this.MEDIMAGE = medImage;
	}

	@Override
	public String toString() {
		return "Medication_Details [MEDID=" + MEDID + ", DESCRIPTION=" + DESCRIPTION + ", MEDNAME=" + MEDNAME
				+ ", medImage=" + Arrays.toString(MEDIMAGE) + "]";
	}

	public Medication_Details(int mEDID, String dESCRIPTION, String mEDNAME, byte[] medImage) {
		super();
		MEDID = mEDID;
		DESCRIPTION = dESCRIPTION;
		MEDNAME = mEDNAME;
		this.MEDIMAGE = medImage;
	}

	public Medication_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
