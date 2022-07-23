package com.learn.springbootsecurity.securityConfig;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learn.springbootsecurity.models.Role;


@Configuration
public class CustomUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	
	private String username;
	private String password;
	private  Set<GrantedAuthority> authorities;
	
	
	public CustomUser() {
		super();
	}

	CustomUser(String username,String password,List<Role> roles)
	{
		this.username = username;
		this.password = password;
		
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		for(Role r:roles)
		    authorities.add(new SimpleGrantedAuthority(r.getRole()));
		
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
