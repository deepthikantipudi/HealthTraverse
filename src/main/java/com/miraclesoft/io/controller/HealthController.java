package com.miraclesoft.io.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.MedicalConditions;
import com.miraclesoft.io.repository.HealthCareRepository;
import com.miraclesoft.io.repository.MedicalConditionsRepository;


@CrossOrigin(origins="*")
@RestController
public class HealthController {
	
	
	
	@Autowired
	private HealthCareRepository healthCareRepository;
	@Autowired
	private MedicalConditionsRepository mcr;
	
	@GetMapping("/conditions-types")
	public List<HealthCare> getConditiontypes() {
		return (List<HealthCare>) healthCareRepository.findAll();
	}

	@PostMapping(value="/add-condition-types", consumes = { "multipart/form-data" })
	public String saveConditionType(
			@RequestParam("conditionName")String conditionName,
			@RequestParam("severity")String severity,
			@RequestParam("triggers")String triggers,
			@RequestParam("diagnosisDate") String diagnosisDate,
			@RequestParam("image")MultipartFile im) throws IOException, ParseException
	{
		
		HealthCare healthCare=new HealthCare();
//		healthCare.setLinkToApi(linkToApi);
		healthCare.setConditionName(severity);
		healthCare.setConditionName(triggers);
		healthCare.setImage(im.getBytes());
		healthCare.setConditionName(conditionName);
		healthCareRepository.save(healthCare);
		MedicalConditions mc = new MedicalConditions();
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(diagnosisDate); 
		mc.setDiagnosisDate(date1);
		mc.setCONDITIONTYPE_ID(healthCare.getConditionTypeId());
		mc.setPid(2);
		mcr.save(mc);
		
		
		return "success";
		
		 
	}
	
	@GetMapping("/conditions-types/{conditionTypeId}")
	public Optional<HealthCare> findByID(@RequestBody Long conditionTypeId) {
		return healthCareRepository.findById(conditionTypeId);
		//.orElseThrow(RecordNotFoundException::new);
	}

    @DeleteMapping("/conditions-types/{id}")
	public String deleteConditions(@PathVariable Long id)
	{
    	healthCareRepository.findById(id).orElseThrow(RecordNotFoundException::new);
		 healthCareRepository.deleteById(id);
		 return "deleted";
	}
	
	
	//

}
