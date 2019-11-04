package com.miraclesoft.io.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	//Medication_Details medi-new Medication_Details();
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
//	 med.set

	 return medrepo.save(med);

	 }
	 
	 //////////////////
	 
	 
	 @GetMapping(value="/getmedpres/{pid}",produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?>  fetchMedications(@Value("${fetchAllPres}") String query, @PathVariable long pid) throws Exception {
		 System.out.println("fetching records from database....");
		 List<Object[]> valueByPid =  medrepo.fetchMedications(query,pid);
		 
		// return abc.get(0).getDosage();
		 HashMap<String, Object> map = new HashMap<>();
			
			
			if (valueByPid != null) {

				map.put("PID", valueByPid.get(0)[0]);
				map.put("DESCRIPTION", valueByPid.get(0)[1]);
				map.put("MEDNAME", valueByPid.get(0)[2]);
				map.put("MEDSCHEDULE", valueByPid.get(0)[3]);
				map.put("MEDIMAGE", valueByPid.get(0)[4]);
				return new ResponseEntity<>(map, HttpStatus.OK);
			} else {

				map.put("ErrorResponse", "No Patient");
				return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}
	         
	         
	    }
	 
	 @GetMapping("/getmeds")
	 public Iterable getmeds() {
		 return medrepo.findAll();
	 }
	 
	 
	 @RequestMapping(value="/editmed/{id}",method=RequestMethod.PUT,consumes = {"multipart/form-data"})
	 public Medication_Details updateMed(@PathVariable int id,@RequestParam("DESCRIPTION") String desc,@RequestParam("MEDNAME") String title,@RequestParam("MEDIMAGE") MultipartFile im) throws IOException {
	    	
		 System.out.println("updating record in database....");
		 Medication_Details med=new Medication_Details();
		 med.setMEDID(id);
		med.setDESCRIPTION(desc);
		 med.setMEDNAME(title);
		// med.setDosage(dosage);
		 med.setMedImage(im.getBytes());
		 return medrepo.save(med);
	    }
	 
	 @DeleteMapping("/deletemed/{medid}")
	    public void deletemed(@PathVariable int medid) {
		 medrepo.findById(medid);
	          			 System.out.println("deleting from database....");

	          			medrepo.deleteById(medid);
	    }

	 
	 
	 @DeleteMapping("/{ppdid}")
	    public void delete(@PathVariable int ppdid) {
	        patientPrescriptionDetailsRepo.findById(ppdid);
	          			 System.out.println("deleting from database....");

	       patientPrescriptionDetailsRepo.deleteById(ppdid);
	    }

	 
	 ////////////// Patient Prescription///////////////////////////////////////////////////
	 
	 @PostMapping("/addPP")
	 public PatientPrescription addPP(@RequestBody PatientPrescription pp) {
		 System.out.println("inserting into database....");

	        return patientPrescriptionRepo.save(pp);
	    }
	 
	 @GetMapping("/getPP")
	 public List<PatientPrescription> getPP() {
		 return patientPrescriptionRepo.findAll();
	 }
	 
	 @DeleteMapping("PP/{presid}")
	    public void deletePP(@PathVariable int presid) {
	        patientPrescriptionRepo.findById(presid);
	          			 System.out.println("deleting from database....");

	       patientPrescriptionRepo.deleteById(presid);
	    }
	 
	 //////////////Patient Prescription Details///////////////////////////////////////////////////
	 
	 @PostMapping("/addPPD")
	 public PatientPrescriptionDetails addPPD(@RequestBody PatientPrescriptionDetails ppd) {
		 System.out.println("inserting into database....");

	        return patientPrescriptionDetailsRepo.save(ppd);
	    }
	 
	 
	 @GetMapping("/getPPDS")
	    public Iterable findAll() {
		 System.out.println("fetching records from database....");
	        return patientPrescriptionDetailsRepo.findAll();
	    }
//	 
	 
	 //////////////////////////////////////////////////////////////////////////////////////
	 
	 

}
