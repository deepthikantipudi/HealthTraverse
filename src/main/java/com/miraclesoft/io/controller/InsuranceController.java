package com.miraclesoft.io.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.model.PatientClaimDetails;
import com.miraclesoft.io.model.PatientInsurancePlan;
import com.miraclesoft.io.services.PatientClaimDetailsService;
import com.miraclesoft.io.services.PatientInsurancePlanService;

@RestController
public class InsuranceController {

	@Autowired
	private PatientClaimDetailsService patientClaimDetailsService;
	
	@Autowired
	private PatientInsurancePlanService patientInsurancePlanService;
	
	@GetMapping("/claims")
	public List<PatientClaimDetails> getClaims(){
		return patientClaimDetailsService.findAll();
	}
	
	@GetMapping("/claims/{pid}")
	public PatientClaimDetails getClaimByPid(@PathVariable("pid") int pid){
		return patientClaimDetailsService.findByPid(pid);
	}
	
	@PostMapping("/addclaim")
	public PatientClaimDetails addClaims(@Valid @RequestBody PatientClaimDetails patientClaimDetails) {
		return patientClaimDetailsService.addClaims(patientClaimDetails);
	}
	
	@PutMapping("/claims/{claimid}")
	public PatientClaimDetails updateClaim(@RequestBody PatientClaimDetails patientClaimDetails, @PathVariable("claimid") int claimId) {
		return patientClaimDetailsService.updateClaim(patientClaimDetails, claimId);
	}
	
	@DeleteMapping("/claims/{claimid}")
	public String deleteClaim(@PathVariable("claimid") int claimId) {
		return patientClaimDetailsService.deleteClaim(claimId);
	}
	
	@GetMapping("/plans")
	public List<PatientInsurancePlan> getPlans(){
		return patientInsurancePlanService.findAll();
	}
	
	@GetMapping("/plans/{pid}")
	public PatientInsurancePlan getInsuranceByPid(@PathVariable("pid") int pid){
	return patientInsurancePlanService.findByPid(pid);
	}
	
	@PostMapping("/addplans")
	public PatientInsurancePlan addPlan(@Valid @RequestBody PatientInsurancePlan patientInsurancePlan) {
		return patientInsurancePlanService.addPlan(patientInsurancePlan);
	}
	
	@PutMapping("/plan/{insid}")
	public PatientInsurancePlan updatePlan(@RequestBody PatientInsurancePlan patientInsurancePlan, @PathVariable("insid") int insId) {
		return patientInsurancePlanService.updatePlan(patientInsurancePlan, insId);
	}
	
	@DeleteMapping("/plan/{insid}")
	public String deletePlan(@PathVariable("insid") int insId) {
		return patientInsurancePlanService.deletePlan(insId);
	}
}
