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

import com.miraclesoft.io.model.AverageGlucoseEntity;
import com.miraclesoft.io.model.FCHealthGL;
import com.miraclesoft.io.repository.FCHealthGLRepository;
import com.miraclesoft.io.services.CommonService;



@RestController
@RequestMapping("/GL")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FCHealthGLContoller {
	
	@Autowired
	FCHealthGLRepository glRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientGLs")
	   public List<FCHealthGL> retrievePatientGL() {
		   return glRepository.findAll();
	   }
	   
	   @PostMapping("/PatientGL")
	   public FCHealthGL newFCHealthGL(@RequestBody FCHealthGL fcGlucose) {
		   fcGlucose.setGlDate(new Date());
		   fcGlucose.setPid(2);
		  // System.out.println(new Date());
		   return glRepository.save(fcGlucose);
	   }

	   @GetMapping("/CurrentGL/{patientId}")
	   public ResponseEntity<?> recentGlOfPatient(@PathVariable("patientId") long patientId, @Value("${glQuery}") String query) {
		  // System.out.println (query);
		   List<Object[]> valueByPid = glRepository.findRecentValueByPid(patientId, query);
		   HashMap<String, Object> map = new HashMap<>();
		   if(valueByPid != null) {
				
			   map.put("currentGlucose", valueByPid.get(0)[0]);
			   map.put("TimeStamp", valueByPid.get(0)[1]);
			   return new ResponseEntity<>(map, HttpStatus.OK);
		   }
		   else {
			
     		   map.put("ErrorResponse", "No Patient");
			    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		   }
	   }
	   
	   
//	   @GetMapping(value="/CurrentWeight/{patientId}",produces=MediaType.APPLICATION_JSON_VALUE)
//	   public ResponseEntity<?>  recentWeightOfPatient(@PathVariable("patientId") long patientId, @Value("${weightQuery}") String query) {
//		  // System.out.println (query);
//		   long valueByPid = weightRepository.findRecentValueByPid(patientId, query);
//		   if(valueByPid != 0)
//			   return new ResponseEntity<>(valueByPid, HttpStatus.OK);
//		   else
//			    return new ResponseEntity<>("No Patient", HttpStatus.BAD_REQUEST);
//	   }
	   @GetMapping(value="/AverageGL/{patientId}/{year}", produces=MediaType.APPLICATION_JSON_VALUE)
	   public List<AverageGlucoseEntity> getAverageGlucoseValues(@PathVariable("patientId") long patientId,@PathVariable("year") int year,@Value("${avgGL}") String query) throws Exception{
		   List<AverageGlucoseEntity> result = glRepository.findGlucoseAverageValues(patientId, query, year);
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
