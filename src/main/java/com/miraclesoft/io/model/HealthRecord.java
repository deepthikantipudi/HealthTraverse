package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HealthRecord")
public class HealthRecord {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID") 
	private long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user_id;

	@ManyToOne
	@JoinColumn(name = "PID")
	private PatientProfile pid;

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

	public HealthRecord(Users user_id, PatientProfile pid, String fileName, String fileURI, String fileType,
			long size) {
		super();
		this.user_id = user_id;
		this.pid = pid;
		this.fileName = fileName;
		this.fileURI = fileURI;
		this.fileType = fileType;
		this.size = size;
	}

	public HealthRecord(long id, Users user_id, PatientProfile pid, String fileName, String fileURI,
			String fileType, long size) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pid = pid;
		this.fileName = fileName;
		this.fileURI = fileURI;
		this.fileType = fileType;
		this.size = size;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public PatientProfile getPid() {
		return pid;
	}

	public void setPid(PatientProfile pid) {
		this.pid = pid;
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
		return "HealthRecord [id=" + id + ", user_id=" + user_id + ", pid=" + pid + ", fileName=" + fileName
				+ ", fileURI=" + fileURI + ", fileType=" + fileType + ", size=" + size + "]";
	}
	
	
}
