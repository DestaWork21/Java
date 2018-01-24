package com.project.DriversLicense.repositories;

import com.project.DriversLicense.models.License;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface LicenseRepository extends CrudRepository<License,Long>{
	// Query methods go here.
	ArrayList<License> findByPersonIdContaining(long id);
	// @Query(value="select persons.id from persons")
	// Example:
	// public YourModelHere findByName(String name);
}
