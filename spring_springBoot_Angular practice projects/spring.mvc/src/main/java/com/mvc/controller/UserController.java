package com.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.UserRegistrationDTO;

@Controller
@RequestMapping("/user")
public class UserController {

	 @GetMapping("/do-register")
	 public ModelAndView doRegister( @ModelAttribute("UserRegistrationDTO") UserRegistrationDTO userRegistrationDTO,Model model)
	 {
		
		 return new ModelAndView("login");
	 }
	 
}
