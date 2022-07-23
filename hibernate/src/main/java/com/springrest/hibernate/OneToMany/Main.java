package com.springrest.hibernate.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Configuration configuration = new Configuration();
		   configuration.configure("oneToMany.cfg.xml");
		   SessionFactory sessionfactory = configuration.buildSessionFactory();
		   
		   Session session = sessionfactory.openSession();
		   Transaction tx = session.beginTransaction();
		   
		   Project p1 = new Project(121,"Company Billing Software","Mr. Bhargav");
		         //Create Employee 
				   Employee emp1 = new Employee(19271155,"Ankit Pathak","8083562104");
				   Employee emp2 = new Employee(19271156,"Santosh Singh","9661524354");
		
				   List<Employee> employee = new ArrayList<Employee>();
				   employee.add(emp1);
				   employee.add(emp2);
				   
				  //Project Association
				   ProjectAssociation pa1 = new ProjectAssociation();
				   pa1.setProjectId(p1.getProjectId());
				   pa1.setTeamMembers(employee);
				   pa1.setTeamLead("Mr. Chadda Sahab");
				   
		  session.save(p1);	   
		  session.save(emp1);
		  session.save(emp2);
		  session.save(pa1);
		   
		  ProjectAssociation proj1 = session.get(ProjectAssociation.class, 121);
		  
		  System.out.println("\n\nProject ID:-"+proj1.getProjectId());
		  System.out.println("Team Leaded By:-"+proj1.getTeamLead());
		  System.out.println("Team Members are below");
		  proj1.getTeamMembers().forEach(e->{
			  System.out.println(" "+e.getEmpId()+" , "+e.getEmpName()+" , "+e.getEmpContact());
		  });
		  
		  
		  
		   
		  tx.commit();
		  session.close();
		  sessionfactory.close();	   
	}

}
