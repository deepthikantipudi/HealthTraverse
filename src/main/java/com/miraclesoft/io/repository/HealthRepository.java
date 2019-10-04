package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.HealthRecord;

@Repository
public interface HealthRepository extends JpaRepository<HealthRecord, Long> {

	HealthRecord findByFileName(String name);
}
