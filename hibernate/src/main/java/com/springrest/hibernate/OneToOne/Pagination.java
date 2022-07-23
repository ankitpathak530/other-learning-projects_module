package com.springrest.hibernate.OneToOne;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.configure("oneToOne.cfg.xml");
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		Query query = session.createQuery("from Question");
		
		//Pagination method 
		query.setFirstResult(0);
		query.setMaxResults(7);
		
		List<Question> ques = query.list();
		ques.forEach(e ->{
			System.out.println("\nQ"+e.getQuestionId()+". "+e.getQuestion()+" \nAnswer:- "+e.getAnswer().getAnswer());
		});
		
		
		
		session.beginTransaction().commit();
		session.close();
		sessionfactory.close();	
	}

}
