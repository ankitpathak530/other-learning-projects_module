package com.jwtauthentication.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home{

	
	  @GetMapping("/welcome")
	  public String welcome() {
		  String text = "this is private page! not allowed for unauthenticate user";
		  return text;  
	  }
	  
	  
	  //This 
	  @GetMapping("/getUser")
	  public String getUser() {
		  return "{\"name\":\"Ankit\"}";
	  }
    

	  
}
