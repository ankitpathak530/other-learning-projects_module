package com.learn.springbootsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.springbootsecurity.models.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

	Customer findByEmail(String email);
}
