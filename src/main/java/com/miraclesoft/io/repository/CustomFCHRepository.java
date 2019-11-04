package com.miraclesoft.io.repository;

import java.util.List;

import com.miraclesoft.io.model.AverageBloodPressureEntity;
import com.miraclesoft.io.model.AverageCholestrolEntity;
import com.miraclesoft.io.model.AverageEntity;
import com.miraclesoft.io.model.AverageGlucoseEntity;
import com.miraclesoft.io.model.MedPrescriptionDTO;



public interface CustomFCHRepository {

	List<Object[]> findRecentValueByPid(long patientId, String query);
	
	List<AverageEntity> findAverageValues(long patientId, String query, int year) throws Exception;
	List<AverageCholestrolEntity> findCholestrolAverageValues(long patientId, String query, int year) throws Exception;
	List<AverageGlucoseEntity> findGlucoseAverageValues(long patientId, String query, int year) throws Exception;
	List<AverageBloodPressureEntity> findAverageBPValues(long patientId, String query, int year) throws Exception;
	
	//Prescription
	List<Object[]> fetchMedications(String query,long pid) throws Exception;
	///
	
	List<Object[]> fetchMedicalconditions(String query, long pid);
}
