package com.learn.springbootsecurity.securityConfig;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@EnableWebSecurity(debug = true)
public class MyWebSecurity_NORMAL_Configuration extends WebSecurityConfigurerAdapter{

	
	@Autowired
    private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		String staticResources[] = {"/images/**"};
		
		http
		    .authorizeRequests()
		    .antMatchers("/testing","/login").permitAll()
		    .antMatchers(staticResources).permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin().loginPage("/login")
		    .and()
		    .httpBasic()
		    .and()
		    .rememberMe().key("rememberMeKey")
		    .and()
		    .logout().deleteCookies("remeberMeKey","JSESSIONID");
		    
		 //If we are using JWT then there is no use of CSRF and managing JSESSIONID token. It is unnecessary redundancy
		 http
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .csrf().disable()
		    .addFilterAfter(new JwtTokenGenerationFilter(), BasicAuthenticationFilter.class)
		    .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class);

	}

	

	// CustomUser CustomuserDetailsService OtherConfiguration  all will not execute because we have commented the neck of chicken
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		  auth
		      .userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}
    

	
	
	
	
	
	

/*
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception
   {
	   // 1st Way    
	   /*
	   auth
	      .inMemoryAuthentication() 
	      .withUser("pathak")
	      .password(bcryptPasswordEncoder.encode("123"))
	      .roles("ADMIN");

	   // Another Way
	  
	   ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	   roles.add(new SimpleGrantedAuthority("ADMIN"));
	   roles.add(new SimpleGrantedAuthority("DSP"));
	   roles.add(new SimpleGrantedAuthority("SP"));
	   
	   User user = new User("ankit032", "1234", roles);
	  
	   

	   // Another Way
	   
	   UserDetails ankitUser = User.withUsername("ankit032").password(bcryptPasswordEncoder.encode("321")).roles("ADMIN","DSP","SP").build();
	   UserDetails amanUser = User.withUsername("aman032").password(bcryptPasswordEncoder.encode("123")).roles("SP").build();
	   
	    auth.inMemoryAuthentication().withUser(amanUser);	
	    auth.inMemoryAuthentication().withUser(ankitUser);
	   
	   
	   
	   // Another Way
	    * InMeoryUserDetailsManager inMemoryUserDetailsService = new InMemoryUserDetailsManager();
		      UserDetails userDetails1  =  UserDetails ankitUser = User.withUsername("ankit032").password(bcryptPasswordEncoder.encode("321")).roles("ADMIN","DSP","SP").build();
		      UserDetails userDetails2  =  User.withUsername("aman032").password(bcryptPasswordEncoder.encode("123")).roles("SP").build();
		  inMemoryUserDetailsService.createUser(userDetails1);
		  inMemoryUserDetailsService.createUser(userDetails2);
		  
		  auth.userDetailsService(inMemoryUserDetailsService)..passwordEncoder(passwordEncoder);
		  
	}
	    *
	    */
	   
	   
	   
   
	
}
