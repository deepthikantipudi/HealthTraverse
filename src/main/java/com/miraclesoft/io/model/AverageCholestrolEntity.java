package com.miraclesoft.io.model;

public class AverageCholestrolEntity {

	private Double avgCL;
	private String avgMonth;
	
	public AverageCholestrolEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AverageCholestrolEntity(Double avgCL, String avgMonth) {
		super();
		this.avgCL = avgCL;
		this.avgMonth = avgMonth;
	}
	public Double getAvgCL() {
		return avgCL;
	}
	public void setAvgCL(Double avgCL) {
		this.avgCL = avgCL;
	}
	public String getAvgMonth() {
		return avgMonth;
	}
	public void setAvgMonth(String avgMonth) {
		this.avgMonth = avgMonth;
	}
	@Override
	public String toString() {
		return "AverageCholestrolEntity [avgCL=" + avgCL + ", avgMonth=" + avgMonth + "]";
	}

}
