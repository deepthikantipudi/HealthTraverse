package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.PatientPrescriptionDetails;

@Repository
public interface PatientPrescriptionDetailsRepo extends JpaRepository<PatientPrescriptionDetails, Integer> {

	
	
}
