package com.learn.springbootsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.springbootsecurity.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
