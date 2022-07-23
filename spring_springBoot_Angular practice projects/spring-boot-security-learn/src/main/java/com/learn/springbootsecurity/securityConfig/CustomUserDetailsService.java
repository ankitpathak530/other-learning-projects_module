package com.learn.springbootsecurity.securityConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.learn.springbootsecurity.models.Customer;
import com.learn.springbootsecurity.repository.CustomerRepository;

@Configuration
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository custRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	    Customer customers = this.custRepo.findByEmail(username);
		    
		    if(customers == null)
		    {
		    	throw new UsernameNotFoundException("Username is not valid");
		    }
		    else
		    {
		    	UserDetails userDetails = new CustomUser(customers.getEmail(),customers.getPassword(),customers.getRoles());
		        return userDetails;
		    }	
	}
}