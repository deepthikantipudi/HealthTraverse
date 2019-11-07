package com.miraclesoft.io.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.miraclesoft.io.model.HealthCare;

public interface HealthCareRepository extends CrudRepository<HealthCare, Long>,CustomFCHRepository{


}
