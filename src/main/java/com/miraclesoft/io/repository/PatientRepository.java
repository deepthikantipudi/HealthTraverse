package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.PatientProfile;

@Repository
public interface PatientRepository extends JpaRepository<PatientProfile, Long>, CustomFCHRepository {
		long findIdBypatientName(String patientName);
}
