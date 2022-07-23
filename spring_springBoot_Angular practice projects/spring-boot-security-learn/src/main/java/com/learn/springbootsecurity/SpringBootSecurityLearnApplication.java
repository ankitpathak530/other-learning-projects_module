package com.learn.springbootsecurity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

import com.learn.springbootsecurity.models.Customer;
import com.learn.springbootsecurity.models.Role;
import com.learn.springbootsecurity.repository.CustomerRepository;
import com.learn.springbootsecurity.repository.RoleRepository;

@SpringBootApplication
public class SpringBootSecurityLearnApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

	
	

}
