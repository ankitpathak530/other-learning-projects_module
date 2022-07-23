package com.springrest.hibernate.Embeddable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 private String name;
	 private boolean isEligible;
	 private EmpQualification empQ;
	
	 
	 
	 
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEligible() {
		return isEligible;
	}
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}
	public EmpQualification getEmpQ() {
		return empQ;
	}
	public void setEmpQ(EmpQualification empQ) {
		this.empQ = empQ;
	}
	public Employee(int id, String name, boolean isEligible, EmpQualification empQ) {
		super();
		this.id = id;
		this.name = name;
		this.isEligible = isEligible;
		this.empQ = empQ;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", isEligible=" + isEligible + ", empQ=" + empQ + "]";
	}
	 
	 
}
