package com.springrest.hibernate.sqlquery;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;


public class SQLExample {

	public static void main(String[] args) {
			
		  Configuration configuration = new Configuration().configure("oneToOne.cfg.xml");
		  SessionFactory sessionfactory = configuration.buildSessionFactory();
		  Session session = sessionfactory.openSession();
		  
		  //To fire HQL we use Session class createQuery() method
		  //To fire SQL we use Session class createSqlQuery() method
		  
		  NativeQuery nq = session.createSQLQuery("select * from student");
		  
		  List<Object[]> stuList = nq.list();
		  
		  stuList.forEach(e->{
			  System.out.println(Arrays.toString(e)+" <---- ");
		  });
		  
		  
		  
		  session.beginTransaction().commit();
		  session.close();
		  sessionfactory.close();
	  
	}
}
