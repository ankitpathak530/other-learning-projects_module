package com.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.jpa.dao.UserRepo;
import com.springboot.jpa.entities.User;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplication.class, args);
	    
		UserRepo userrepo = context.getBean(UserRepo.class);

		     User user1 = new User("Ankit pathak","Aurangabad");
     	     User user2 = new User("Ramgopal","Tamilnadu");
		     User user3 = new User("Santnu Shukla","Motihari");
		     User user4 = new User("Satish sen","Chapra wale");
		     User user5 = new User("Santosh","Tetrain");
		     
			  
		   //save multiple User
		     List<User> allusers = List.of(user1,user2,user3,user4,user5);
		     Iterable<User> all_users = userrepo.saveAll(allusers);
		    
		     all_users.forEach(user->{
		    	 System.out.println(user);
		     });      
		
	 
		   
	/*   Update Operation
	 
	        Optional<User> optional = userrepo.findById(5);
		    User user55 = optional.get();
		    
		    user55.setAddress("Aurangabad");
		    userrepo.save(user55);
		    
	 */
		      
	  
	 /*    Delete Operation
	      
	      userrepo.deleteById(5);
	      userrepo.deleteAll();
	      userrepo.delete(null);
	      
	  */
	     
	 /*   
		     Iterable<User> iterable =  userrepo.findAll();  
		     iterable.forEach(System.out::println);
		 
	 */
		
	//	  userrepo.findByNameAndAddress("Santosh", "Auranabad").forEach(System.out::println);;
	//      userrepo.findByNameLike("%san%").forEach(System.out::println); 
		    
	      
	      
	      
	}
          
}
