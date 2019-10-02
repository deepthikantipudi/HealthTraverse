package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	//@Query("select u from USERS u where u.username = ?1")
	public Users findByUsername(String username);

}
