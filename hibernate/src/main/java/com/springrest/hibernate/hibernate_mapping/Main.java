package com.springrest.hibernate.hibernate_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SessionFactory sessionfactory = new Configuration().configure("Person.cfg.xml").buildSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        Person p1 = new Person(12,"Ankit","Abad");
        session.save(p1);
        
        tx.commit();
        session.close();
	}

}
