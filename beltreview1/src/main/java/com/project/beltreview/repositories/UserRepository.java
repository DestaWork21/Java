package com.project.beltreview.repositories;

import com.project.beltreview.models.User;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	
	User findByEmail(String email);
	User findById(long id);
	ArrayList<User> findAll();
	
}
