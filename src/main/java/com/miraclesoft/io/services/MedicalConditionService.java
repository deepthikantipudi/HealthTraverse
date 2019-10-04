package com.miraclesoft.io.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.PatientProfile;
import com.miraclesoft.io.repository.HealthCareRepository;
import com.miraclesoft.io.repository.PatientRepository;

@Service
public class MedicalConditionService {
	
	@Autowired
	private HealthCareRepository healthCareRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
    public Optional<HealthCare> getConditionTypeId(Long id)
    {
    	return healthCareRepository.findById(id);
    }

    public Optional<PatientProfile> getPatientById(Long id)
    {
    	return patientRepository.findById(id);
    }
}
