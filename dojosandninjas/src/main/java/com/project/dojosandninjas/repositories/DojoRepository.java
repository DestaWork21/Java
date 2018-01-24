package com.project.dojosandninjas.repositories;

import com.project.dojosandninjas.models.Dojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface DojoRepository extends CrudRepository<Dojo,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
