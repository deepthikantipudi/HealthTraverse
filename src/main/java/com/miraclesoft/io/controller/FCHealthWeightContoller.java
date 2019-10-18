package com.miraclesoft.io.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.model.AverageEntity;
import com.miraclesoft.io.model.FCHealthWeight;
import com.miraclesoft.io.repository.FCHealthWeightRepository;
import com.miraclesoft.io.services.CommonService;



@RestController
@RequestMapping("/Weight")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FCHealthWeightContoller {
	
	@Autowired
	private FCHealthWeightRepository weightRepository;
	
	@Autowired
	private CommonService commonService;
	
	   @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientWeights")
	   public List<FCHealthWeight> retrievePatientWeight() {
		   
		   List<FCHealthWeight> lis = null;
		   
		   try {
			   lis = weightRepository.findAll();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return lis;
	   }
	   
         @PostMapping("/PatientWeight")
	       public FCHealthWeight newFCHealthWeight(@RequestBody FCHealthWeight fcWeight) {
        	 fcWeight.setWeightDate(new Date());
        	 
//        	 Calendar cal = Calendar.getInstance();
//        	 fcWeight.setDay(cal.get(Calendar.DAY_OF_MONTH));
//  		   System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//  		   
//  		   fcWeight.setYear(cal.get(Calendar.YEAR));
//  		   System.out.println(cal.get(Calendar.YEAR));
//  		   
//  		   fcWeight.setMonth(cal.get(Calendar.MONTH));
//  		   System.out.println(cal.get(Calendar.MONTH));
        	 fcWeight.setPid((long) 2);
        	
		  // System.out.println(new Date());
		   return weightRepository.save(fcWeight);
	   }
	   
//	   @PostMapping(value="/PatientWeight",produces=MediaType.APPLICATION_JSON_VALUE)
//	   public ResponseEntity<?> newFCHealthWeight(@RequestBody FCHealthWeight fcWeight) {
//		   fcWeight.setWeightDate(new Date());
//		   Date today = new Date();
//		   Calendar cal = Calendar.getInstance();
//		   fcWeight.setDay(cal.get(Calendar.DAY_OF_MONTH));
//		   System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//		   
//		   fcWeight.setYear(cal.get(Calendar.YEAR));
//		   System.out.println(cal.get(Calendar.YEAR));
//		   
//		   fcWeight.setMonth(cal.get(Calendar.MONTH));
//		   System.out.println(cal.get(Calendar.MONTH));
//		   
//		   fcWeight.setPid(new Long(2));
//		  // System.out.println(new Date());
//		   FCHealthWeight weight = weightRepository.save(fcWeight);
//		   return new ResponseEntity<>(weight.getWeight(), HttpStatus.OK);
//	   }
//	  

	   @GetMapping(value="/CurrentWeight/{patientId}",produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?> recentWeightOfPatient(@PathVariable("patientId") long patientId, @Value("${weightQuery}") String query) {
		  // System.out.println (query);
		   long valueByPid = weightRepository.findRecentValueByPid(patientId, query);
		   
		   HashMap<String, Object> map = new HashMap<>();

//		    map.put("currentWeight", valueByPid);

		   
		   if(valueByPid != 0) {
			   map.put("currentWeight", valueByPid);
			   return new ResponseEntity<>(map, HttpStatus.OK);
		   }
		   else {
			   map.put("ErrorResponse", "No Patient");
			    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			  
		   }
			   
	   }
	   
	   @GetMapping(value="/AverageWeight/{patientId}/{year}", produces=MediaType.APPLICATION_JSON_VALUE)
	   public List<AverageEntity> getAverageValues(@PathVariable("patientId") long patientId,@PathVariable("year") int year,@Value("${avgWeight}") String query) throws Exception{
		   List<AverageEntity> result = weightRepository.findAverageValues(patientId, query, year);
		   if(!(result.isEmpty())) {
			   
			  System.out.println("INSIDE coNTROLLER:"+result);
			   return result;
			   //return new ResponseEntity<>((FCHealthWeight)result, HttpStatus.OK);
		   }
		   else
			    //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		   return null;
	   }
	   
}
