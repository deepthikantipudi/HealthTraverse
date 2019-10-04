//package com.miraclesoft.io.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.miraclesoft.io.model.Users;
//import com.miraclesoft.io.repository.UserRepo;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private UserRepo userRepo;
//	
//	public Users getUserById(long id) {
//		return userRepo.findById(id).get();
//	}
//}

package com.miraclesoft.io.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraclesoft.io.model.UserDetail;
import com.miraclesoft.io.repository.UserRepo;
import com.miraclesoft.io.repository.UserRepository;
import com.miraclesoft.io.model.Users;

@Service
@Transactional
public class UserService {

	@Autowired
    UserRepository userRepository;
	
	@Autowired
	private UserRepo userRepo;
	
	public Users getUserById(long id) {
		return userRepo.findById(id).get();	
	}

    public List<UserDetail> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserDetail addUser(UserDetail user) {
        return this.userRepository.save(user);
    }
    
    public UserDetail getUserWithId(Integer id) {
    	return this.userRepository.getUserWithId(id);
    }
    
    public List<UserDetail> findAll() {
    	return this.userRepository.findAll();
    }
}

