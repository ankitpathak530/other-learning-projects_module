package com.springrest.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
   public static void main(String[] args) {
	
	   Configuration configuration = new Configuration();
	   configuration.configure("oneToOne.cfg.xml");
	   SessionFactory sessionfactory = configuration.buildSessionFactory();
	   
	   Session session = sessionfactory.openSession();
	   
	
	   Question q1 = new Question();
	   q1.setQuestionId(121);
	   q1.setQuestion("What is java?");
	        Answer a1 = new Answer();
	        a1.setAnswerId(34);
	        a1.setAnswer("Java is programming language");
	        a1.setQuestion(q1);
	   q1.setAnswer(a1);
	   
	   //To save into database
	   session.save(q1);
	   session.save(a1);
	 
	   //Fetching value  FIRST-LEVEL CAshing automatic Enable by hibernate.
	   
	  Question question =  session.get(Question.class, 121);
      System.out.println(question.getQuestion()+"\t"+question.getAnswer().getAnswer()+"\n\n");
	  System.out.println(session.contains(question)); 
	   
	  //Second time to get Same object hibernate will not talk to database 
	  Question question2 = session.get(Question.class, 121);
	  System.out.println(question2.getQuestion()+"\t"+question2.getAnswer().getAnswer()+"\n\n");
		 
	   
	   
	   session.beginTransaction().commit();
	   session.close();
	   sessionfactory.close();	   
 }
}
