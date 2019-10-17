package com.miraclesoft.io.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraclesoft.io.ExceptionHandler.RecordIdMismatchException;
import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.MedPrescriptionDTO;
import com.miraclesoft.io.model.Medication_Details;
import com.miraclesoft.io.model.PatientPrescription;
import com.miraclesoft.io.model.PatientPrescriptionDetails;
import com.miraclesoft.io.repository.MedicationRepository;
import com.miraclesoft.io.repository.PatientPrescriptionDetailsRepo;
import com.miraclesoft.io.repository.PatientPrescriptionRepo;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/medications")
public class MedicationController {
	
	@Autowired
	MedicationRepository medrepo;
	
	@Autowired
	PatientPrescriptionRepo patientPrescriptionRepo;
	
	@Autowired
	PatientPrescriptionDetailsRepo patientPrescriptionDetailsRepo;
//	   ObjectMapper Obj = new ObjectMapper(); 
	
	
	 
//	 @PostMapping("/addmedication")
//	 public Medication_Details create(@Valid @RequestBody Medication_Details med) {
//		 System.out.println("inserting into database....");
//
//	        return medrepo.save(med);
//	    }
	 
	 
	 @RequestMapping(value="/addmedication",method=RequestMethod.POST,consumes = {"multipart/form-data"})
	 public Medication_Details addmedication(@RequestParam("DESCRIPTION") String desc,@RequestParam("MEDNAME") String title,@RequestParam("MEDIMAGE") MultipartFile im) throws IOException {
	 System.out.println("inserting into database....");


	// medrepo.save(med);
	 Medication_Details med=new Medication_Details();
	 med.setDESCRIPTION(desc);
	 med.setMEDNAME(title);
	// med.setDosage(dosage);
	 med.setMedImage(im.getBytes());

	 return medrepo.save(med);

	 }
	 
	 //////////////////
	 
	 
	 @GetMapping(value="/getmedpres",produces=MediaType.APPLICATION_JSON_VALUE)
	    public List<Object[]> fetchMedications(@Value("${fetchAllPres}") String query) throws Exception {
		 System.out.println("fetching records from database....");
		 return medrepo.fetchMedications(query);
		 
		// return abc.get(0).getDosage();
	         
	         
	    }
	 
	 
	 
	 
//	 @PutMapping("/{id}")
//	 public Medication_Details updateMed(@RequestBody Medication_Details med, @PathVariable Long id) {
//	    	
//		 System.out.println("updating record in database...."+id);
//		 /*
//		 Medication_Details med1=medrepo.findById(id).get();
//		 
//		String desc=med.getDESCRIPTION();
//	        med1.setDESCRIPTION(desc);
//	         
//	        return medrepo.save(med1);
//	        */
//		 med.setMEDID(id);
//
//		 
//		 if(med.getMEDID()!=id) {                                         //checking the employee id 
//			 throw new RecordIdMismatchException();
//		}
//		medrepo.findById(id).orElseThrow(RecordNotFoundException::new);
//		//emp.setId(eid);
//		return medrepo.save(med);
//	    }
//	 
	 @DeleteMapping("/{id}")
	    public void delete(@PathVariable int id) {
	        medrepo.findById(id);
	          			 System.out.println("deleting from database....");

	        medrepo.deleteById(id);
	    }

	 
	 ////////////// Patient Prescription///////////////////////////////////////////////////
	 
	 @PostMapping("/addPP")
	 public PatientPrescription addPP(@RequestBody PatientPrescription pp) {
		 System.out.println("inserting into database....");

	        return patientPrescriptionRepo.save(pp);
	    }
	 
	 
	 //////////////Patient Prescription Details///////////////////////////////////////////////////
	 
	 @PostMapping("/addPPD")
	 public PatientPrescriptionDetails addPPD(@RequestBody PatientPrescriptionDetails ppd) {
		 System.out.println("inserting into database....");

	        return patientPrescriptionDetailsRepo.save(ppd);
	    }
	 
//	 @GetMapping("/getPPDS")
//	    public Iterable findAll() {
//		 System.out.println("fetching records from database....");
//	        return patientPrescriptionDetailsRepo.findAll();
//	    }
//	 
	 
	 //////////////////////////////////////////////////////////////////////////////////////
	 
	 

}
