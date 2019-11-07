package com.miraclesoft.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.MedicalConditions;


@Repository
public interface MedicalConditionsRepository extends CrudRepository<MedicalConditions, Long>, CustomFCHRepository {

//	@Query(value=" FROM com.miraclesoft.io.model.MedicalConditions pmc INNER JOIN com.miraclesoft.io.model.HealthCare hc ON hc.conditionTypeId=pmc.CONDITIONTYPE_ID WHERE pmc.pid=?1")
//	List getMedic(long pid);

//	List<Object[]> fetchMedications(String query);
	
//	public List<MedicalConditions> findByPatient(Long  pid);// changed   --Patient p
	
	
	
}
