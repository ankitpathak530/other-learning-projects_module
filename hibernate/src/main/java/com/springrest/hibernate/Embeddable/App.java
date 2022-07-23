package com.springrest.hibernate.Embeddable;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.configure("embHibernate.cfg.xml");
		
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		Employee e1 = new Employee();
		e1.setName("Rahul prasad");
		e1.setEligible(true);
		
				EmpQualification eq = new EmpQualification();
				eq.setIntermediate(true);
				eq.setGraduate(false);
		
		e1.setEmpQ(eq);
		session.save(e1);
		
		
		session.beginTransaction().commit();
		session.close();
		sessionfactory.close();
		
		
	}

}
