package com.project.javabelt.repositories;

import com.project.javabelt.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	// Query methods go here.
	User findByEmail(String email);
	
	// Example:
	// public YourModelHere findByName(String name);
}
