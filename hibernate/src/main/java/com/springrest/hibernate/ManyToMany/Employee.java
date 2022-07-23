package com.springrest.hibernate.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;

import org.hibernate.engine.profile.Fetch;

@Entity
public class Employee {

	 @Id
	 @Column(name="emp_id")
	 private int empId;
	 
	 @Column(name="emp_name")
	 private String empName;
	 
	 @ManyToMany(fetch = FetchType.EAGER)  //By default FetchType is Lazy
	 @JoinTable(
			 name="emp_learn",
			 joinColumns = {@JoinColumn(name="eid")} ,
			 inverseJoinColumns = {@JoinColumn(name="pid")}
			 )
	 
	 private List<Project> projects;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, List<Project> projects) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.projects = projects;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", projects=" + projects + "]";
	}
	 
	 
	 
}
