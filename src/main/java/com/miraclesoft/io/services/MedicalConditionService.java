package com.miraclesoft.io.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.MedicalConditions;
import com.miraclesoft.io.model.PatientProfile;
//import com.miraclesoft.io.model.Patient;
import com.miraclesoft.io.repository.HealthCareRepository;
import com.miraclesoft.io.repository.MedicalConditionsRepository;
import com.miraclesoft.io.repository.PatientRepository;

@Service
public class MedicalConditionService {
	
	@Autowired
	private HealthCareRepository healthCareRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired 
	MedicalConditionsRepository medicalConditionsRepository;
	

	
    public Optional<HealthCare> getConditionTypeId(Long id)
    {
    	return healthCareRepository.findById(id);
    }

    public Optional<PatientProfile> getPatientById(Long id)
    {
    	return patientRepository.findById(id);
    }

	public MedicalConditions addConditions(MedicalConditions medicalConditions) {
		// TODO Auto-generated method stub
		return medicalConditionsRepository.save(medicalConditions);

	}
    
    
//    public List<HealthCare> getMedicalConditionsByPatientId(long pid)
//	{
//		
//		
//		PatientProfile patient = new PatientProfile();
//		PatientProfile.setId(pid);
//		
//		List<MedicalConditions> mCList = medicalConditionsRepository.findByPatient(patient);
//		
//		List<HealthCare> li = new ArrayList<HealthCare>();
//		
//		for(MedicalConditions mc : mCList) {
//			
//			li.add(mc.getHealthCare());
//			
//			
//		}
//		
//		return li;
//	
//	}
    


}
