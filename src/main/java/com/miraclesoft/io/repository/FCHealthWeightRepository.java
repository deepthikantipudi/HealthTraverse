package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.FCHealthWeight;


@Repository
public interface FCHealthWeightRepository extends JpaRepository<FCHealthWeight, Long>, CustomFCHRepository {
	//long findWeightByPid(long patientId);
}
