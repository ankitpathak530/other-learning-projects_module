package com.learn;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learn.config.CustomUserDetails;
import com.learn.model.Role;
import com.learn.model.User;
import com.learn.repository.UserRepository;

@SpringBootApplication
public class OAuthSpringAngularApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repo;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(OAuthSpringAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(repo.count() == 0)
		{
			repo.save(new User("user","user",Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
		}
	}
	
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo ) throws Exception
	{
		  builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				 return new CustomUserDetails(repo.findByUsername(username).get());
			}
		});
	}
	

}
