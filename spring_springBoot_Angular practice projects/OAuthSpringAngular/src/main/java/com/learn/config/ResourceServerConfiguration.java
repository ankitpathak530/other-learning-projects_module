package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
	
		  http
		     .authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/private/**").authenticated();
		     
		    http.csrf().disable();
		    http.headers().frameOptions().disable();
	}

	
	
}
