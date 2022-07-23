package com.springrest.hibernate.OneToMany_Cascading;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	  @Id
	  @Column(name="emp_id")
	  private int empId;
		
	  @Column(name="emp_name")
	  private String empName;
		  
	  @Column(name="emp_contact")
      private String empContact;
		  
	  @ManyToOne
      private ProjectAssociation projectAssociation;
      
	  
	public Employee() {
		super();
	}


	public Employee(int empId, String empName, String empContact) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empContact = empContact;
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


	public String getEmpContact() {
		return empContact;
	}


	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}


	public ProjectAssociation getProjectAssociation() {
		return projectAssociation;
	}


	public void setProjectAssociation(ProjectAssociation projectAssociation) {
		this.projectAssociation = projectAssociation;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empContact=" + empContact
				+ ", projectAssociation=" + projectAssociation + "]";
	}
    
	
}
