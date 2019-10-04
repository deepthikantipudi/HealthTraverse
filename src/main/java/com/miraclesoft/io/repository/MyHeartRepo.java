package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.MyHeart;



@Repository
public interface MyHeartRepo extends JpaRepository<MyHeart, Long> {

}
