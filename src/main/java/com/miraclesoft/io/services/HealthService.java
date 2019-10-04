package com.miraclesoft.io.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.model.HealthRecord;
import com.miraclesoft.io.repository.HealthRepository;

@Service
public class HealthService {
	
	private static final Logger LOG = LoggerFactory.getLogger(HealthService.class);

	@Autowired
	private HealthRepository healthRepo;
	
	public HealthRecord saveHealthRecord(HealthRecord record) {
		return healthRepo.save(record);
	}
	
	public HealthRecord getHealthRecord(String fname) {
		 LOG.info("Inside Health record service  ");
		HealthRecord hRecord =null;
		try {
			LOG.info("Retrieving the file name  ");
			if(fname!=null) {
				hRecord = healthRepo.findByFileName(fname);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hRecord;
	}
	
	
}
