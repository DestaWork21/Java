package com.project.ProductsAndCatagories.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ProductsAndCatagories.models.Product;

@Repository 												
public interface ProductRepository extends CrudRepository<Product,Long>{
	// Query methods go here.
	ArrayList<Product> findAll();

	List<Product> findByNameNotIn(List<String> name);
	// Example:
	// public YourModelHere findByName(String name);
}
