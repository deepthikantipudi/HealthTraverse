package com.miraclesoft.io.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.model.Resource;
import com.miraclesoft.io.repository.ResourceRepository;



@Service
public class ResourceService {
	@Autowired
	ResourceRepository rr;

	public Optional<Resource> getResource(Long id) {
		return rr.findById(id);
	}


}
