package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="HEALTH_RECORD")
public class HealthRecord {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID") 
	private long id;

//	@ManyToOne
//	@JoinColumn(name = "USER_ID")
//	private Users user_id;
//
//	@ManyToOne
//	@JoinColumn(name = "PID")
//	private PatientProfile pid;

	@Column(name="PID")
	private long pId;
	
	@Column(name="USER_ID")
	private long userId;
	
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_DOWNLOAD_URI")
	private String fileURI;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="SIZE")
	private long size;

	public HealthRecord() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileURI() {
		return fileURI;
	}

	public void setFileURI(String fileURI) {
		this.fileURI = fileURI;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "HealthRecord [id=" + id + ", pId=" + pId + ", userId=" + userId + ", fileName=" + fileName
				+ ", fileURI=" + fileURI + ", fileType=" + fileType + ", size=" + size + "]";
	}

	public HealthRecord(long pId, long userId, String fileName, String fileURI, String fileType, long size) {
		super();
		this.pId = pId;
		this.userId = userId;
		this.fileName = fileName;
		this.fileURI = fileURI;
		this.fileType = fileType;
		this.size = size;
	}

	
	
	
	
}
