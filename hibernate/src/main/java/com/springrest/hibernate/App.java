package com.springrest.hibernate;


import java.io.FileInputStream;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException
    { 	
  
        System.out.println( "Project started.!" );
      	
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");        
        SessionFactory sessionfactory = configuration.buildSessionFactory();
      
        Session session = sessionfactory.openSession();
        session.beginTransaction();
                  
        
                   Student st1 = new Student(1,"Shyam chandra");
                   
                   FileInputStream fis = new FileInputStream("src/main/java/two.png");
			       byte img[] = new byte[fis.available()];
			       fis.read(img);  
			       Address ad1 = new Address("Ram-RAj murti",true,img,new Date(4),99);
        
		//  session.save(ad1); 
		//  session.save(st1);
      
				   session.getTransaction().commit();
        
        session.close();
    }
    
    
    
    
}
