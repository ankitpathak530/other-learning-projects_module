package com.jwtauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwtauthentication.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurity  extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserdetailsService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.customUserdetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  
		 http.csrf().disable().authorizeRequests().antMatchers("/token")
		 .permitAll()
		 .antMatchers("/welcome")
		 .permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and()
		 .exceptionHandling().authenticationEntryPoint(entryPoint);
		 
		 
		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	
	} 
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
    	return NoOpPasswordEncoder.getInstance();
    }
	
	@Bean
	public AuthenticationManager authenticationManagerBean()throws Exception{
		return super.authenticationManager();
	}
	
}
