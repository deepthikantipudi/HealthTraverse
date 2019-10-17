package com.miraclesoft.io.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.MedicalConditions;
import com.miraclesoft.io.model.PatientClaimDetails;
import com.miraclesoft.io.model.PatientProfile;
import com.miraclesoft.io.repository.MedicalConditionsRepository;
import com.miraclesoft.io.services.MedicalConditionService;



@RestController
@CrossOrigin(origins="*")
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
	
	
//	@PostMapping("/add-medical-conditions")
//	public MedicalConditions addConditions(@RequestBody MedicalConditions medicalConditions)
//	{
//		
//		
//		medicalConditions.setHealthCare(medicalConditionService.
//				getConditionTypeId(medicalConditions.getHealthCare().getConditionTypeId()).get());
//		
//		PatientProfile patient =new PatientProfile();
//		patient.setId(medicalConditions.getPatient().getId());
//		medicalConditions.setPatient(patient);
//	
//		return medicalConditionsRepository.save(medicalConditions);
//	}
	
	
//	@PostMapping("/add-medical-conditions")
//	public MedicalConditions addConditions(@RequestBody MedicalConditions medicalConditions)
//	{
//		System.out.println("In Post");
//		repo
//		
//	}
	
	
	@PostMapping("/add-medical-conditions")
	public MedicalConditions addConditions(@RequestBody MedicalConditions medicalConditions) {
		return medicalConditionService.addConditions(medicalConditions);
	}
	
	
    @DeleteMapping("/medical-conditions/{id}")
	public String deleteConditions(@PathVariable Long id)
	{
    	medicalConditionsRepository.findById(id).orElseThrow(RecordNotFoundException::new);
		 medicalConditionsRepository.deleteById(id);
		 return "deleted";
	}
//    
    
//    @GetMapping("/medical-condition/{pid}")
//    public List<HealthCare> getByPid(@PathVariable Long pid){
//    	
//    return  medicalConditionService.getMedicalConditionsByPatientId(pid);
//    
//    	
//    	
//    	
//    }
    
    
//	 @GetMapping(value="/medical-condition/{pid}",produces=MediaType.APPLICATION_JSON_VALUE)
//	    public List<Object[]> fetchMedications(@Value("${fetchAllmedictions}") String query, @PathVariable("pid") long pid) throws Exception {
//		 System.out.println("fetching records from database....");
//		 return medicalConditionsRepository.fetchMedicalconditions(query,pid);	         
//	         
//	    }
	    
	    
	    @GetMapping(value="/medical-condition/{pid}",produces=MediaType.APPLICATION_JSON_VALUE)
	    public List<Object[]> fetchMedications(@PathVariable("pid") long pid) throws Exception {
		 System.out.println("fetching records from database....");
		 return medicalConditionsRepository.getMedic(pid);	         
	         
	    }

    
}
