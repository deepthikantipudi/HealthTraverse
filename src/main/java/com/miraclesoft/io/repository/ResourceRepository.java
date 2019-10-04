package com.miraclesoft.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.Resource;



@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {
}