package com.project.JavaBelt1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
