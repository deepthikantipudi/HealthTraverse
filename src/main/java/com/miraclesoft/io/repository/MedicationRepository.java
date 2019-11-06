package com.miraclesoft.io.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.miraclesoft.io.model.MedPrescriptionDTO;
import com.miraclesoft.io.model.Medication_Details;


public interface MedicationRepository extends CrudRepository<Medication_Details,Integer>, CustomFCHRepository{
	
//	@Query("SELECT new com.roytuts.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d INNER JOIN d.employees e")
//	@Query(value="SELECT md.DESCRIPTION,md.MEDNAME,ppd.dosage,ppd.mediInstructions FROM Medication_Details md INNER JOIN PatientPrescriptionDetails ppd ON md.MEDID=ppd.medid")
//	List<MedPrescriptionDTO> fetchMedications();
	
//	@Query("SELECT new com.miraclesoft.io.model.MedPrescriptionDTO(md.DESCRIPTION,md.MEDNAME, ppd.dosage, ppd.mediInstructions) "
//			+ "FROM Medication_Details md INNER JOIN md.MedId")
//	List<MedPrescriptionDTO> fetchMedications();
	
//	@Query(value="SELECT md.DESCRIPTION,md.MEDNAME FROM Medication_Details md INNER JOIN PatientPrescriptionDetails ppd ON md.MEDID=ppd.medid")
//	List<Medication_Details> fetchMedications();
	
//	@Query(value="FROM Medication_Details md Inner JOIN PatientPrescriptionDetails ppd ON md.MEDID=ppd.medid ")
//	List<Medication_Details> fetchMedications();
	
//	@Query(value="SELECT ppd.PID,md.DESCRIPTION,md.MEDNAME, ppd.DOSAGE, ppd.MEDI_INSTRUCTIONS FROM [dbo].[MEDICATION_DETAILS] md INNER JOIN [dbo].[PATIENT_PRESCRIPTION_DETAILS] ppd ON md.MEDID=ppd.MEDID WHERE ppd.PID=?1")
//	List getMedic(long pid);

}
