package com.miraclesoft.io.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.repository.HealthCareRepository;


@RestController
public class HealthController {
	
	
	
	@Autowired
	private HealthCareRepository healthCareRepository;
	
	@GetMapping("/conditions-types")
	public List<HealthCare> getConditiontypes() {
		return (List<HealthCare>) healthCareRepository.findAll();
	}

	@PostMapping("/add-condition-types")
	public HealthCare addConditiontypes(@RequestBody HealthCare healthCare)
	{
		
	 return healthCareRepository.save(healthCare);
		
	}
	
	@GetMapping("/conditions-types/{id}")
	public HealthCare findByID(@RequestBody Long id) {
		return healthCareRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}
	
	//

}
