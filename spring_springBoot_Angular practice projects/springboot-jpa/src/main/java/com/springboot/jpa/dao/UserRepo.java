package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entities.User;


public interface UserRepo extends CrudRepository<User,Integer>{

	/*
	 //Use any number of Custom method here followed by structure "Spring query method "
	 public List<User> findByNameOrderByName(String name);
	 public List<User> findByNameAndAddress(String name,String address);
	 public List<User> findByNameLike(String like);
	 public List<User> findByNameStartingWith(String prefix);
	 public List<User> findByNameEndingWith(String postfix);
	 public List<User> findByNameContaining(String words);
	 public List<User> findByIdLessThan(String words);
	 public List<User> findByIdGreaterThanEqual(String words);
	 
	 
	 //WE can fire native query or jpql query using @Query annotation
	 @Query("select u from User u")
	 public List<User> getAllUsers();
	 
	 @Query("select u from User where name=:n")
	 public List<User> getAllUsersByName(@Param("n")String name);
	 
	 @Query("select u from User where u.name=:c and u.password=:p")
	 public List<User> getAllUsersByUsernamePassword(@Param("c")String username,@Param("p")String password);
	 
	 
	 //Native Query "SQl"
	 @Query(value="select * from user",nativeQuery=true)
	 public List<User> allUsers();
	 
	 
	 
	 */
}
