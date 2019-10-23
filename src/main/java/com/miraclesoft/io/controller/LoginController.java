package com.miraclesoft.io.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.model.Users;
import com.miraclesoft.io.repository.UserRepo;

@RestController
public class LoginController {
	
	
	@Autowired
	UserRepo userRepo;

	@PostMapping(value="/login")
	private ResponseEntity<?>  performLogin(@RequestBody Users users) {
		String usr=users.getUsername();
		String pswd=users.getPassword();
		HashMap<String, Object> map = new HashMap<>();
		
		if(usr!=null && pswd!=null) {
			
			Users u=userRepo.authentiacateUsers(usr, pswd);
			if(u!=null) {
//			return user.getRoles();
			
			   map.put("Role", u.getRoles());
			    return new ResponseEntity<>(map, HttpStatus.OK);
			
			}
			else {
				  map.put("Error Response", "Invalid Credentials");
				  return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);

			}
		}
		else {
			 map.put("Error Response", "Bad Request");
			  return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
}
