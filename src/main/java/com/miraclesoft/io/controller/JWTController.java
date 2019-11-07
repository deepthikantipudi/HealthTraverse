package com.miraclesoft.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.io.awt.service.JwtService;
import com.miraclesoft.io.awt.util.JWTUtility;
import com.miraclesoft.io.model.JwtRequest;
import com.miraclesoft.io.model.JwtResponse;

@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders="*", exposedHeaders="*")
public class JWTController {

	@Autowired
	JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtility jwtTokenUtil;

//	@Autowired
//	UserRepo userRepo;

	@RequestMapping(value = "/login")
	public String login() {

		// Here I redirect to facebook

		return "";

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		// authenticate(authenticationRequest.getUsername(),
		// authenticationRequest.getPassword());
		System.out.println("UserName:" + authenticationRequest.getUsername());
		System.out.println("Password:" + authenticationRequest.getPassword());
		// Authentication

		// authorization
		final UserDetails userDetails = jwtService.loadUserByUsername(authenticationRequest.getUsername());

		// if(true) {

		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("token is:  " + token);

		String[] roles = new String[userDetails.getAuthorities().size()];

//			System.out.println(userDetails.getAuthorities().toArray(roles));
//			
//			roles = userDetails.getAuthorities().toArray(roles);

		roles[0] = userDetails.getAuthorities().toString();

		return ResponseEntity.ok(new JwtResponse(token, roles));

		// }else {
		// return (ResponseEntity<?>) ResponseEntity.badRequest();
		// }

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/anyResource")
	public String getAnyResource(@RequestHeader("jwt-token") String token) {

		// to cross check jwt token

		final UserDetails userDetails = jwtService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));

		if (jwtTokenUtil.validateToken(token, userDetails)) {
			return "success";
		} else {
			return "failure";
		}

	}

}