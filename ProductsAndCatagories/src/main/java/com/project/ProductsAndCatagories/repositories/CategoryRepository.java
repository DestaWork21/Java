package com.project.ProductsAndCatagories.repositories;

import com.project.ProductsAndCatagories.models.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CategoryRepository extends CrudRepository<Category,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	ArrayList<Category> findAll();

	List<Category> findByNameNotIn(List<String> name);
}
