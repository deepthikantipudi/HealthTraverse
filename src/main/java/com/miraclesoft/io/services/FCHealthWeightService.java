package com.miraclesoft.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.repository.FCHealthWeightRepository;


@Service
public class FCHealthWeightService {
	@Autowired
	FCHealthWeightRepository weightRepository;

}
