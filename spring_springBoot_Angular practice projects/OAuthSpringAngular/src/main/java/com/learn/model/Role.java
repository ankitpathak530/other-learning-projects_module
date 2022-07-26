package com.learn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne
	private User user;
	

	public Role() {
	}
	public Role(String name) {
		this.name = name;
	}
	public Long getId() {     
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}