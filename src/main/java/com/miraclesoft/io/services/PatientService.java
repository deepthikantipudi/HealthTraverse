package com.miraclesoft.io.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.model.PatientProfile;
import com.miraclesoft.io.repository.PatientRepository;

@Service
public class PatientService {
	
	private static final Logger LOG = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepository patientRepo;
	
	public PatientProfile getPatientById(long id) {
		LOG.info("Getting Patient Info by ID");
		return patientRepo.findById(id).get();	
	}
}
