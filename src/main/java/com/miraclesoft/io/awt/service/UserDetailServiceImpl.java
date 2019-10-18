//package com.miraclesoft.io.awt.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.miraclesoft.io.awt.dao.UserDAO;
//import com.miraclesoft.io.model.Users;
//import com.miraclesoft.io.repository.UserRepo;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//	@Autowired
//	UserDAO userDao;
//	
//	@Autowired
//	UserRepo userrepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		
////		List<String> rolesList= new ArrayList<String>();
//		/*Here we are using dummy data, you need to load user data from
//        database or other third party application*/
//	//Users userFromDB = userDao.findByUsername(username);
////		
////		Users userFromDB = new Users();
////		
////		userFromDB.setUsername("admin");
////		
////		userFromDB.setPassowrd("admin");
////		
////		userFromDB.setRole("admin");
////		
//		
//		Users userFromDB = userrepo.findByUsername(username);
//		
//		
//		UserBuilder builder = null;
//		if (userFromDB != null) {
//			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.password(new BCryptPasswordEncoder().encode(userFromDB.getPassword()));
//			System.out.println("Roles are:"+userFromDB.getRoles());
////			rolesList.add(userFromDB.getRoles());
////			builder.roles(rolesList);							
//			builder.roles(userFromDB.getRoles());
//		} else {
//			throw new UsernameNotFoundException("User not found.");
//		}
//
//		return builder.build();
//	}
//
//}
//
