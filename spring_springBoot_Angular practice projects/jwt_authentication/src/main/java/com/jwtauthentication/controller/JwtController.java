package com.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauthentication.helper.JwtUtilHelper;
import com.jwtauthentication.model.JwtRequest;
import com.jwtauthentication.model.JwtResponse;
import com.jwtauthentication.service.CustomUserDetailsService;
     
@RestController
@CrossOrigin( origins = "*")
public class JwtController {
    
	@Autowired
	private CustomUserDetailsService customUserDetailService; //contain method loadUserByUsername() return userDetails
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtilHelper jwtUtilHelper;
	
	@GetMapping("/check")
	  public String welcome() {
		  String text = "this is mic check";
		  return text;  
	  }
	  	
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest)throws Exception {
		
		System.out.println("This   is jwtRequest----->"+jwtRequest);
		
		try {
			
	 	 	this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
			 
		}catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad credential username not found");
		}
		catch(BadCredentialsException e) {
			throw new Exception("Bad credential");
		}
		
		//Authenticated user 
		UserDetails userDetail = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtilHelper.generateToken(userDetail);
		
		System.out.println("JWT "+token);
		
		//{"token":"value"}
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
}
