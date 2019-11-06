package com.miraclesoft.io.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.miraclesoft.io.model.MedicalConditions;

public class PatientController {
	@GetMapping("/patients/{id}/medical-conditions")
	public List<MedicalConditions> getByPatientId(@PathVariable long id)
	{
		return null;
		
	}

}
