package com.miraclesoft.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.miraclesoft.io.model.HealthCare;

public interface HealthCareRepository extends CrudRepository<HealthCare, Long>,JpaRepository<HealthCare, Long>,CustomFCHRepository{

//	@Modifying
//
//	@Query(value= "BEGIN TRANSACTION "
//			+ "update [TEST_DB].[dbo].[HEALTHCARE]"+
//					"set [HEALTHCARE].CONDITION_NAME = ?,[HEALTHCARE].SEVERITY=?"+
//					"from [TEST_DB].[dbo].[HEALTHCARE] hc, [TEST_DB].[dbo].[PATIENT_MEDICAL_CONDITIONS] pmc"+
//					"WHERE hc.CONDITIONTYPE_ID=pmc.CONDITIONTYPE_ID"+
//					"AND pmc.CONDITIONTYPE_ID=237"+
//					"update [TEST_DB].[dbo].[PATIENT_MEDICAL_CONDITIONS]"+
//					"set [PATIENT_MEDICAL_CONDITIONS].DIAGNOSIS_DATE=?"+
//					"from [TEST_DB].[dbo].[HEALTHCARE] hc, [TEST_DB].[dbo].[PATIENT_MEDICAL_CONDITIONS] pmc"+
//					"WHERE hc.CONDITIONTYPE_ID=pmc.CONDITIONTYPE_ID"+
//					"AND pmc.CONDITIONTYPE_ID=237"+
//					"COMMIT" )
//	List<Object[]> updatemedConditions(String query);
	
	
}
