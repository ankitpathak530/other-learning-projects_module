package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.UserRegistrationDTO;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") UserRegistrationDTO urd)
	{
		
		return "login";
	}
	
	@RequestMapping(value="/process-login",method = RequestMethod.GET)
	public String processsLogin(@ModelAttribute("user") UserRegistrationDTO urd)
	{
		return "userIndex";
	}
	

	@RequestMapping("/register")
	public ModelAndView register()
	{
		return new ModelAndView("user-registration-page");
	}
	
	
	
	
}
