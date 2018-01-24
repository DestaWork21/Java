package com.project.DriversLicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.DriversLicense.models.Person;

@Repository 												
public interface PersonRepository extends CrudRepository<Person,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
