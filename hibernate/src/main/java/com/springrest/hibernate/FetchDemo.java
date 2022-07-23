package com.springrest.hibernate;

import org.hibernate.cfg.Configuration;



import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             //get //load
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		Address ad1 = (Address)session.get(Address.class,3);
		System.out.println(ad1);
		
		
		
		
		
		
		session.close();
		sessionfactory.close();
	}

}
