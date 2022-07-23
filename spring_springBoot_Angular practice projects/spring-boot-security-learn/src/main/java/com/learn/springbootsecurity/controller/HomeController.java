package com.learn.springbootsecurity.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springbootsecurity.models.Customer;
import com.learn.springbootsecurity.service.CustomerService;






@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CustomerService custService;

	
	
	

	@GetMapping("/home")
	public String home(OAuth2AccessToken token)
	{
		System.out.print(token);
		return "home";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "myLogin";
	}
	
	@GetMapping("/testing")
	public String testing()
	{
		return "testing";
	}
	
	@GetMapping("/logout")
	public String newFile()
	{
		return "logout";
	}

	@PostMapping("/save")
	@ResponseBody
	public Customer save(@RequestBody Customer customer)
	{
		return this.custService.save(customer);
	}
	
	
	
	
	@GetMapping("/customer")
	public List<Customer> allCustomer()
	{
		return this.custService.allCustomer();
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
	     return this.custService.deleteCustomer(id);
	}
	
	
	
	
	
	
}
