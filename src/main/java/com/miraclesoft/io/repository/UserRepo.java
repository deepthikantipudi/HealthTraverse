package com.miraclesoft.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	
	//@Query("select u from USERS u where u.username = ?1")
	public Users findByUsername(String username);
	
	@Query("FROM Users u where u.username = ?1 AND u.password=?2")
	public Users authentiacateUsers(String username, String password);

}
