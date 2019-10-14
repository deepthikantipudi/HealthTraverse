package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.FCHealthCL;


@Repository
public interface FCHealthCLRepository extends JpaRepository<FCHealthCL, Long>, CustomFCHRepository{

}
