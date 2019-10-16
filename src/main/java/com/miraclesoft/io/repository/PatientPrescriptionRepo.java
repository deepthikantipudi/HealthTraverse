package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.PatientPrescription;

@Repository
public interface PatientPrescriptionRepo extends JpaRepository<PatientPrescription, Integer> {

}
