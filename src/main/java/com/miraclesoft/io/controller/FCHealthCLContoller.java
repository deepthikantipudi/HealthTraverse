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

import com.miraclesoft.io.model.AverageCholestrolEntity;
import com.miraclesoft.io.model.FCHealthCL;
import com.miraclesoft.io.repository.FCHealthCLRepository;
import com.miraclesoft.io.services.CommonService;



@RestController
@RequestMapping("/CL")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FCHealthCLContoller {
	
	@Autowired
	FCHealthCLRepository clRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientCLs")
	   public List<FCHealthCL> retrievePatientCL() {
		   return clRepository.findAll();
	   }
	   
	   @PostMapping("/PatientCL")
	   public FCHealthCL newFCHealthCl(@RequestBody FCHealthCL fcChol) {
		   fcChol.setClDate(new Date());
		   fcChol.setPid(2);
		  // System.out.println(new Date());
		   return clRepository.save(fcChol);
	   }

	   @GetMapping("/CurrentCL/{patientId}")
	   public ResponseEntity<?> recentClOfPatient(@PathVariable("patientId") long patientId, @Value("${clQuery}") String query) throws Exception {
		  // System.out.println (query);
		   
		   List<Object[]> valueByPid = clRepository.findRecentValueByPid(patientId, query);
		   HashMap<String, Object> map = new HashMap<>();

		   if(valueByPid != null) {
			
			   map.put("currentCholestrol", valueByPid.get(0)[0]);
			   map.put("TimeStamp", valueByPid.get(0)[1]);
			   return new ResponseEntity<>(map, HttpStatus.OK);
		   }
		   else {
			
			   map.put("ErrorResponse", "No Patient");
			    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		   }
	   }
	   
	   @GetMapping(value="/AverageCL/{patientId}/{year}", produces=MediaType.APPLICATION_JSON_VALUE)
	   public List<AverageCholestrolEntity> getAverageCholestrolValues(@PathVariable("patientId") long patientId,@PathVariable("year") int year,@Value("${avgCL}") String query) throws Exception{
		   List<AverageCholestrolEntity> result = clRepository.findCholestrolAverageValues(patientId, query, year);
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
