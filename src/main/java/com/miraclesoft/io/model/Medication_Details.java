package com.miraclesoft.io.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Medication_Details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="MEDID")
//	@OneToMany(fetch = FetchMode.LAZY, mappedBy = "stock")
	private int MEDID;
	// @NotNull
	 //@Size(min=2, message="Description should have atleast 2 characters")
	@Column(name="DESCRIPTION")
	private String DESCRIPTION;
	
	@Column(name="MEDNAME")
	private String MEDNAME;
	
	@Column(name="MEDIMAGE")
	private byte[] MEDIMAGE;
	@Column(name="MEDSCHEDULE")
	private String MEDSCHEDULE;
	public Medication_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Medication_Details(int mEDID, String dESCRIPTION, String mEDNAME, byte[] mEDIMAGE, String mEDSCHEDULE) {
		super();
		MEDID = mEDID;
		DESCRIPTION = dESCRIPTION;
		MEDNAME = mEDNAME;
		MEDIMAGE = mEDIMAGE;
		MEDSCHEDULE = mEDSCHEDULE;
	}
	


	public byte[] getMEDIMAGE() {
		return MEDIMAGE;
	}


	public void setMEDIMAGE(byte[] mEDIMAGE) {
		MEDIMAGE = mEDIMAGE;
	}


	public String getMEDSCHEDULE() {
		return MEDSCHEDULE;
	}


	

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


	public void setMEDSCHEDULE(String mEDSCHEDULE2) {
		// TODO Auto-generated method stub
		MEDSCHEDULE= mEDSCHEDULE2;
		
	}

	

	
	
	
	
	
	
	

}
