package com.miraclesoft.io.model;

import javax.persistence.Column;

public class AverageBloodPressureEntity {
	
	private Double avgLowBP;
	private Double avgHighBP;
	private String avgMonth;
	
	public AverageBloodPressureEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AverageBloodPressureEntity(Double avgLowBP, String avgMonth) {
		super();
		this.avgLowBP = avgLowBP;
		this.avgMonth = avgMonth;
	}
	


	public AverageBloodPressureEntity(String avgMonth,Double avgHighBP) {
		super();
		this.avgHighBP = avgHighBP;
		this.avgMonth = avgMonth;
	}


	public AverageBloodPressureEntity(Double avgLowBP, Double avgHighBP, String avgMonth) {
		super();
		this.avgLowBP = avgLowBP;
		this.avgHighBP = avgHighBP;
		this.avgMonth = avgMonth;
	}


	public Double getAvgLowBP() {
		return avgLowBP;
	}


	public void setAvgLowBP(Double avgLowBP) {
		this.avgLowBP = avgLowBP;
	}


	public Double getAvgHighBP() {
		return avgHighBP;
	}


	public void setAvgHighBP(Double avgHighBP) {
		this.avgHighBP = avgHighBP;
	}


	public String getAvgMonth() {
		return avgMonth;
	}


	public void setAvgMonth(String avgMonth) {
		this.avgMonth = avgMonth;
	}


	@Override
	public String toString() {
		return "AverageBloodPressureEntity [avgLowBP=" + avgLowBP + ", avgHighBP=" + avgHighBP + ", avgMonth="
				+ avgMonth + "]";
	}


	
	
}
