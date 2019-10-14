package com.miraclesoft.io.model;

public class AverageGlucoseEntity {
	private Double avgGL;
	
	private String avgMonth;
	public AverageGlucoseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AverageGlucoseEntity(Double avgGL, String avgMonth) {
		super();
		this.avgGL = avgGL;
		this.avgMonth = avgMonth;
	}
	public Double getAvgGL() {
		return avgGL;
	}
	public void setAvgGL(Double avgGL) {
		this.avgGL = avgGL;
	}
	public String getAvgMonth() {
		return avgMonth;
	}
	public void setAvgMonth(String avgMonth) {
		this.avgMonth = avgMonth;
	}
	@Override
	public String toString() {
		return "AverageGlucoseEntity [avgGL=" + avgGL + ", avgMonth=" + avgMonth + "]";
	}
	

}
