package com.learn.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learn.model.Role;
import com.learn.model.User;


public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authority;
	
	
	public CustomUserDetails(User byUsername)
	{
		this.username =  byUsername.getUsername();
		this.password = byUsername.getPassword();
		
			 List<GrantedAuthority> listAuthority = new ArrayList<>();
			 List<Role> roles = byUsername.getRoles();
			 for(Role role:roles)	 
			      listAuthority.add(new SimpleGrantedAuthority(role.getName()));
			 
		 this.authority = listAuthority;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authority;
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
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
