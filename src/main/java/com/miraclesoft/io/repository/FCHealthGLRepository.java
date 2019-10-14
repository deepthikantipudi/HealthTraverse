package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.FCHealthGL;


@Repository
public interface FCHealthGLRepository extends JpaRepository<FCHealthGL, Long>, CustomFCHRepository {

}
