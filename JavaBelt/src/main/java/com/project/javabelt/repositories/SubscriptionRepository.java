package com.project.javabelt.repositories;

import java.util.ArrayList;
import java.util.List;
import com.project.javabelt.models.Subscription;
// import com.project.javabelt.services.subscriptionService;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface SubscriptionRepository extends CrudRepository<Subscription,Long>{
	// Query methods go here.
	List<Subscription> findAll();
	Subscription findBySubscriptionName(String subscriptionName);
	// Example:
	// public YourModelHere findByName(String name);
}
