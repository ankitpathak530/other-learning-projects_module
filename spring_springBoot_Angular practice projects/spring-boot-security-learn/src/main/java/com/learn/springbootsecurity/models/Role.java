package com.learn.springbootsecurity.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Role {

	@GeneratedValue
	@Id
	private long id;	
	private String role;
	
		
	
	public Role() {
		super();
	}
	
	public Role(long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role(String role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
	
	
	
	
}
