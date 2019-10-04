package com.miraclesoft.io.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.ExceptionHandler.RecordIdMismatchException;
import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.PatientInsurancePlan;
import com.miraclesoft.io.repository.PatientInsurancePlanRepo;

@Service
public class PatientInsurancePlanService {
	@Autowired
	private PatientInsurancePlanRepo patientInsurancePlanRepo;
	
	public List<PatientInsurancePlan> findAll(){
		return patientInsurancePlanRepo.findAll();
	}
	
	public PatientInsurancePlan findByPid(int pId){
		return patientInsurancePlanRepo.findById(pId).orElseThrow(RecordNotFoundException::new);
	}
	
	public PatientInsurancePlan addPlan(PatientInsurancePlan patientInsurancePlan) {
		return patientInsurancePlanRepo.save(patientInsurancePlan);
	}
	
	public PatientInsurancePlan updatePlan(PatientInsurancePlan patientInsurancePlan, int insId) {
		if(patientInsurancePlan.getInsId() != insId) {
			throw new RecordIdMismatchException();
		}
		patientInsurancePlanRepo.findById(insId).orElseThrow(RecordNotFoundException::new);
		return patientInsurancePlanRepo.save(patientInsurancePlan);
	}
	
	public String deletePlan(int insId) {
		patientInsurancePlanRepo.findById(insId).orElseThrow(RecordNotFoundException::new);
		patientInsurancePlanRepo.deleteById(insId);
		return "Deleted";
	}
}
