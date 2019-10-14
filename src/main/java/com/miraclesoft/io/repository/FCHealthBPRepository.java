package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.FCHealthBP;


@Repository
public interface FCHealthBPRepository extends JpaRepository<FCHealthBP, Long>, CustomFCHRepository {

}
