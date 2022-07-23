package com.springrest.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
   public static void main(String[] args) {
	   
	     Configuration configuration = new Configuration();
	     configuration.configure("manyToMany.cfg.xml");
	     
	     SessionFactory sessionfactory = configuration.buildSessionFactory();
	     
	     
	     Employee emp1 = new Employee();
	     emp1.setEmpId(298);
	     emp1.setEmpName("Raghaw Singh");
	     
	     
	     Employee emp2 = new Employee();
	     emp2.setEmpId(299);
	     emp2.setEmpName("Raman Chandra");
	     
	     Employee emp3 = new Employee();
	     emp3.setEmpId(300);
	     emp3.setEmpName("Jitu Pathak ");
	          
	     Project p1 = new Project();
	     p1.setProjectId(121);
	     p1.setProjectName("Web Project");
	     
	     Project p2 = new Project();
	     p2.setProjectId(13);
	     p2.setProjectName("C sharp pro.");
	       
			     List<Employee> employee = new ArrayList<Employee>();	     
			     List<Project> project = new ArrayList<Project>();
			     
			     employee.add(emp1);
			     employee.add(emp2);
			     employee.add(emp3);
			     
			     project.add(p1);
			     project.add(p2);
			     
	    emp1.setProjects(project);
	    emp2.setProjects(project);
	    emp3.setProjects(project);
	    
	    p1.setEmployee(employee);
	    p2.setEmployee(employee);
	    
	    Session session = sessionfactory.openSession();
	    
	     session.save(p1);
	     session.save(p2);
	     session.save(emp1);
	     session.save(emp2);
	     session.save(emp3);
	     
	  Project project5 = (Project)session.get(Project.class, 121);
	  
      System.out.println(project5.getProjectId());
	  System.out.println(project5.getProjectName());

	
	     session.beginTransaction().commit();
	     session.close();
	     sessionfactory.close();
   }
}
