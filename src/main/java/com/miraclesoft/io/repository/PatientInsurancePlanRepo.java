package com.miraclesoft.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miraclesoft.io.model.PatientInsurancePlan;

public interface PatientInsurancePlanRepo extends JpaRepository<PatientInsurancePlan, Integer>{

	@Query(value="FROM PatientInsurancePlan p where pId=?1")
	List<PatientInsurancePlan> findByPid(long pId);
}
