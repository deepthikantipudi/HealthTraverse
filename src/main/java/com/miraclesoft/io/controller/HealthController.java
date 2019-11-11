package com.miraclesoft.io.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.*;

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

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.HealthCare;
import com.miraclesoft.io.model.MedicalConditions;
import com.miraclesoft.io.model.Medication_Details;
import com.miraclesoft.io.repository.HealthCareRepository;
import com.miraclesoft.io.repository.MedicalConditionsRepository;


@CrossOrigin(origins="*")
@RestController
public class HealthController {
	
	@Autowired
	EntityManager entityManager;
	
	
	@Autowired
	private HealthCareRepository healthCareRepository;
	@Autowired
	private MedicalConditionsRepository mcr;
	
	@GetMapping("/conditions-types")
	public List<HealthCare> getConditiontypes() {
		return (List<HealthCare>) healthCareRepository.findAll();
	}

	@PostMapping(value="/add-condition-types", consumes = { "multipart/form-data" })
	public String saveConditionType(
			@RequestParam("conditionName")String conditionName,
			@RequestParam("severity")String severity,
			@RequestParam("triggers")String triggers,
			@RequestParam("diagnosisDate") String diagnosisDate,
			@RequestParam("linkToApi") String linkToApi,
			@RequestParam("image")MultipartFile im) throws IOException, ParseException
	{
		
		HealthCare healthCare=new HealthCare();
//		healthCare.setLinkToApi(linkToApi);
		healthCare.setSeverity(severity);
		healthCare.setLinkToApi(linkToApi);
		healthCare.setTriggers(triggers);
		healthCare.setImage(im.getBytes());
		healthCare.setConditionName(conditionName);
		healthCareRepository.save(healthCare);
		MedicalConditions mc = new MedicalConditions();
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(diagnosisDate); 
		mc.setDiagnosisDate(date1);
		mc.setCONDITIONTYPE_ID(healthCare.getConditionTypeId());
		mc.setPid(2);
		mcr.save(mc);
		
		
		return "success";
		
		 
	}
//	@RequestMapping(value="/update-condition-types/{conditionTypeId}", method = RequestMethod.PUT, consumes = { "multipart/form-data" })
//	public List<Object[]> updateConditionType(@Value("${fetchAllmedictions}") String query,
//			@PathVariable Long conditionTypeId)
//			
//	{
//		
//		 System.out.println("fetching records from database....");
//		 return healthCareRepository.updatemedConditions(query,conditionTypeId);        
//	         
		
		 
//	}
	
	@GetMapping("/conditions-types/{conditionTypeId}")
	public Optional<HealthCare> findByID(@RequestBody Long conditionTypeId) {
		return healthCareRepository.findById(conditionTypeId);
		//.orElseThrow(RecordNotFoundException::new);
	}

    @DeleteMapping("/conditions-types/{id}")
	public String deleteConditions(@PathVariable Long id)
	{
		 healthCareRepository.deleteById(id);
		 return "deleted";
	}
    
   
    @GetMapping(value="/medical-condition/{pid}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fetchMedicalcondition(@Value("${fetchAllmedictions}") String query, @PathVariable long pid) throws Exception{
    	System.out.println("fetching records from database....");
		List<Object[]> valueByPid = healthCareRepository.fetchMedicalconditions(query, pid);
		
		System.out.println(valueByPid);
         
		// return abc.get(0).getDosage();
		List li =new ArrayList<>();
		HashMap<String, Object> map;

     	if (valueByPid != null) {
        	for (Object[] result : valueByPid) {
			map = new HashMap<>();
			map.put("PID", result[0]);
			map.put("ConditionType_ID", result[1]);
			map.put("DiagnosisDate", result[2]);
			map.put("Condition_Name", result[3]);
			map.put("Severity", result[4]);
			map.put("Triggers", result[5]);
			map.put("Image", result[6]);
			map.put("LinktoAPI", result[7]);
			li.add(map);
		
			
			
    		}
			
			return new ResponseEntity<>(li, HttpStatus.OK);
		} else {
			map = new HashMap<>();
			map.put("ErrorResponse", "No Patient");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
    
    }
	@RequestMapping(value = "/editmed/{id}", method = RequestMethod.PUT)
	public HealthCare updateMedCond(
//			@Value("${fetchID}") String query, 
	        @PathVariable long id,
			@RequestParam(value = "conditionName", required=false)String conditionName,
			@RequestParam(value="severity", required=false)String severity,
			@RequestParam(value="triggers",required=false)String triggers,
//			@RequestParam(value="diagnosisDate",required=false) String diagnosisDate,
			@RequestParam(value="linkToApi",required=false) String linkToApi,
			@RequestParam(value="image", required=false)MultipartFile im ) throws IOException, ParseException{
		HealthCare healthCare=new HealthCare();
		System.out.println("updating record in database....");
		
//		Query sql = entityManager.createNamedQuery("SELECT pmc.CONDITIONTYPE_ID FROM [TEST_DB].[dbo].PATIENT_MEDICAL_CONDITIONS pmc where pmc.CONDITIONTYPE_ID=:id");
//		Query sql = session.createQuery("SELECT * FROM [TEST_DB].[dbo].PATIENT_MEDICAL_CONDITIONS pmc where pmc.CONDITIONTYPE_ID=:id");
//		 long value = healthCareRepository.fetchId(query, id);
//        long value1 = (long) value.get(0)[0];		
		healthCare.setConditionTypeId(id);
		healthCare.setSeverity(severity);
		healthCare.setConditionName(conditionName);
		healthCare.setImage(im.getBytes());
		healthCare.setTriggers(triggers);
		
		
		
		// med.setDosage(dosage);
		healthCare.setLinkToApi(linkToApi);
//		MedicalConditions mc = new MedicalConditions();
//		mc.setCONDITIONTYPE_ID(value);
//		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(diagnosisDate); 
//				mc.setDiagnosisDate(date1);
//		mcr.save(mc);
		return healthCareRepository.save(healthCare);
	}
	
	
	//

}
