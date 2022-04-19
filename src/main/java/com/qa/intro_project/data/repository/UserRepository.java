package com.qa.intro_project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.intro_project.data.entity.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
