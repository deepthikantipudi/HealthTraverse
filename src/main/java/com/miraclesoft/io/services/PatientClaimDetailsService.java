package com.miraclesoft.io.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.ExceptionHandler.RecordIdMismatchException;
import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.PatientClaimDetails;
import com.miraclesoft.io.repository.PatientClaimDetailsRepo;

@Service
public class PatientClaimDetailsService {
	
	@Autowired
	private PatientClaimDetailsRepo patientClaimDetailsRepo;
	
	public List<PatientClaimDetails> findAll()
	{
		return patientClaimDetailsRepo.findAll();
	}
	
	public List<PatientClaimDetails> findByPid(long pId){
		return patientClaimDetailsRepo.findByPid(pId);
	}
	
	public PatientClaimDetails addClaims(PatientClaimDetails patientClaimDetails) {
		return patientClaimDetailsRepo.save(patientClaimDetails);
	}
	
	public PatientClaimDetails updateClaim(PatientClaimDetails patientClaimDetails, long claimId) {
		if(patientClaimDetails.getClaimId() != claimId) {
			throw new RecordIdMismatchException();
		}
		patientClaimDetailsRepo.findById(claimId).orElseThrow(RecordNotFoundException::new);
		return patientClaimDetailsRepo.save(patientClaimDetails);
	}
	
	public String deleteClaim(long claimId) {
		patientClaimDetailsRepo.findById(claimId).orElseThrow(RecordNotFoundException::new);
		patientClaimDetailsRepo.deleteById(claimId);
		return "Deleted";
	}

}
