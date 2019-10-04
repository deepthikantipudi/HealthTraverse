package com.miraclesoft.io.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.ExceptionHandler.RecordIdMismatchException;
import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.Medication_Details;
import com.miraclesoft.io.repository.MedicationRepository;



@RestController
@RequestMapping("/api/medications")
public class MedicationController {
	
	@Autowired
	MedicationRepository medrepo;
	
	 @GetMapping
	    public Iterable findAll() {
		 System.out.println("fetching records from database....");
	        return medrepo.findAll();
	    }
	 
	 @PostMapping("/addmedication")
	 public Medication_Details create(@Valid @RequestBody Medication_Details med) {
		 System.out.println("inserting into database....");

	        return medrepo.save(med);
	    }
	 
	 
	 @PutMapping("/{id}")
	 public Medication_Details updateMed(@RequestBody Medication_Details med, @PathVariable Long id) {
	    	
		 System.out.println("updating record in database...."+id);
		 /*
		 Medication_Details med1=medrepo.findById(id).get();
		 
		String desc=med.getDESCRIPTION();
	        med1.setDESCRIPTION(desc);
	         
	        return medrepo.save(med1);
	        */
		 med.setMEDID(id);

		 
		 if(med.getMEDID()!=id) {                                         //checking the employee id 
			 throw new RecordIdMismatchException();
		}
		medrepo.findById(id).orElseThrow(RecordNotFoundException::new);
		//emp.setId(eid);
		return medrepo.save(med);
	    }
	 
	 @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        medrepo.findById(id);
	          			 System.out.println("deleting from database....");

	        medrepo.deleteById(id);
	    }


}
