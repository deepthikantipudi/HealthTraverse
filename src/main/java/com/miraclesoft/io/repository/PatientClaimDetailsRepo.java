package com.miraclesoft.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miraclesoft.io.model.PatientClaimDetails;

public interface PatientClaimDetailsRepo extends JpaRepository<PatientClaimDetails, Long>{

	@Query(value="FROM PatientClaimDetails p WHERE pId=?1")
	List<PatientClaimDetails> findByPid(long pId);
}
