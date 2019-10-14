package com.miraclesoft.io.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.MediaList;

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.MedicalConditions;
import com.miraclesoft.io.model.PatientProfile;
import com.miraclesoft.io.repository.MedicalConditionsRepository;
import com.miraclesoft.io.services.MedicalConditionService;


@CrossOrigin(origins="*")
@RestController
public class MedicalConditionsController {
	
	@Autowired
	private MedicalConditionsRepository medicalConditionsRepository;
	
	@Autowired
	private MedicalConditionService medicalConditionService; 
	
	PatientProfile patient;  
	
	@GetMapping("/medical-conditions")
	public List<MedicalConditions> getConditions() {
		return (List<MedicalConditions>) medicalConditionsRepository.findAll();
	}
    
	@GetMapping("/medical-conditions/{id}")
	public MedicalConditions getById(@PathVariable long id)
	{
		return medicalConditionsRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}
	
	@PostMapping("/add-medical-conditions")
	public MedicalConditions addConditions(@RequestBody MedicalConditions medicalConditions)
	{
		
		
		medicalConditions.setHealthCare(medicalConditionService.
				getConditionTypeId(medicalConditions.getHealthCare().getConditionTypeId()).get());
		
		PatientProfile patient =new PatientProfile();
		patient.setPid(medicalConditions.getPatient().getPid());
		medicalConditions.setPatient(patient);
	
		return medicalConditionsRepository.save(medicalConditions);
	}
	
    @DeleteMapping("/medical-conditions/{id}")
	public String deleteConditions(@PathVariable Long id)
	{
    	medicalConditionsRepository.findById(id).orElseThrow(RecordNotFoundException::new);
		 medicalConditionsRepository.deleteById(id);
		 return "deleted";
	}
}
