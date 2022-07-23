package com.springrest.hibernate.OneToOne;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainUsingQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Configuration configuration = new Configuration();
		 configuration.configure("oneToOne.cfg.xml");
		 
		 SessionFactory sessionfactory = configuration.buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 
		 Transaction tx = session.beginTransaction();
		 
		 
		 /* Update
		  * 
	     Query query2 = session.createQuery("update  Answer  set answer=:x where answerId=:id");
		 query2.setParameter("x","Java is very easy to learn.");
		  query2.setParameter("id",343);
		  int i = query2.executeUpdate();
		 System.out.println(i+" row affected.");
		 
		Query query3  = session.createQuery("from Answer");
		List<Answer> ansResult = query3.list();
		System.out.println(ansResult);
		 */
		 
		Query query = session.createQuery("select q.questionId , q.question , a.answer from Question q INNER JOIN "
		 		+ "q.answer as a");
		
		List<Object[]> all = query.getResultList();
		all.forEach(e->{
		   System.out.println(Arrays.toString(e));
		});
		
		 
		 tx.commit();
		 session.close();
	}

}
