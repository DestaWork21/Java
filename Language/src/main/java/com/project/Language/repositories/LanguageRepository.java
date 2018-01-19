package com.project.Language.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.Language.models.Language;

@Repository 												
public interface LanguageRepository extends CrudRepository<Language,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
