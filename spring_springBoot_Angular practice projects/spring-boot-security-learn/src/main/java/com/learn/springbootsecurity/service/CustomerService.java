package com.learn.springbootsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.learn.springbootsecurity.models.Customer;
import com.learn.springbootsecurity.repository.CustomerRepository;

@Service
public class CustomerService {

	

	@Autowired
    private CustomerRepository custRepo;	
	
	
	
	
	public Customer findCustomerByEmail(String email)
	{
		return this.custRepo.findByEmail(email);
	}
	
	public Customer save(Customer customer)
	{
		return this.custRepo.save(customer);  
	}
	
	public List<Customer> allCustomer()
	{
		return (List<Customer>) this.custRepo.findAll();
	}

	public String deleteCustomer(int id)
	{
		Customer cust = new Customer();
		cust.setId(id);
		try {
	    	this.custRepo.delete(cust);
		return "Deleted";
		}catch(IllegalArgumentException e) {
			return "Data not exist";
		}
	}
	
	
	
	
}
