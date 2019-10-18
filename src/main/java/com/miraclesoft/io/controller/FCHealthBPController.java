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

import com.miraclesoft.io.model.AverageBloodPressureEntity;
import com.miraclesoft.io.model.FCHealthBP;
import com.miraclesoft.io.repository.FCHealthBPRepository;
import com.miraclesoft.io.services.CommonService;


@RestController
@RequestMapping("/BP")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FCHealthBPController {
	
	@Autowired
	FCHealthBPRepository bpRepository;
	@Autowired
	FCHealthBP fchealthBp;
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientBPs")
	   public List<FCHealthBP> retrievePatientBP() {
		   return bpRepository.findAll();
	   }
	   
	   @PostMapping("/PatientBP")
	   public FCHealthBP newFCHealthBP(@RequestBody FCHealthBP fchBP) {
		   fchBP.setBpDate(new Date());
		   fchBP.setPid(2);
//		   fchBP.setId(2);
		  // System.out.println(new Date());
		   return bpRepository.save(fchBP);
	   }

	   @GetMapping(value="/CurrentBP/{patientId}",produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?>  recentBpOfPatient(@PathVariable("patientId") long patientId, @Value("${highBpQuery}") String query1, @Value("${lowBpQuery}") String query2) {
		   long highBp = bpRepository.findRecentValueByPid(patientId, query1);
		   long lowBp = bpRepository.findRecentValueByPid(patientId, query2);
		   
		   if(highBp != 0 && lowBp != 0  ) {
			   fchealthBp.setHighBP(highBp);
			   fchealthBp.setLowBP(lowBp);
			   System.out.println(fchealthBp);
			return new ResponseEntity<>(fchealthBp, HttpStatus.OK);
		}
		   else{
			   HashMap<String, Object> map = new HashMap<>();
			   map.put("ErrorResponse", "No Patient");
			    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			  
		   }
	   }
	   
	   @GetMapping(value="/AverageBP/{patientId}/{year}", produces=MediaType.APPLICATION_JSON_VALUE)
	   public List<AverageBloodPressureEntity> getAverageBPValues(@PathVariable("patientId") long patientId,@PathVariable("year") int year,@Value("${avgHLBP}") String query) throws Exception{
		   List<AverageBloodPressureEntity> result = bpRepository.findAverageBPValues(patientId, query, year);
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