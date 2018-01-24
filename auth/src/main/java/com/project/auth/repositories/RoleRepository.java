package com.project.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.models.Role;

@Repository 												
public interface RoleRepository extends CrudRepository<Role,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
