package com.project.javabelt.services;

import com.project.javabelt.models.Subscription;
import com.project.javabelt.repositories.SubscriptionRepository;
import java.util.ArrayList;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
	// Member variables / service initializations go here
	private SubscriptionRepository subscriptionRepository; 	
	public SubscriptionService(SubscriptionRepository subscriptionRepository){
		this.subscriptionRepository=subscriptionRepository;
	}
	
	// Crud methods to act on services go here.
	public void create(Subscription subscription){
		subscriptionRepository.save(subscription);
				
		}
	
	public SubscriptionRepository getSubscriptionRepository() {
		return subscriptionRepository;
		
	}
	
	public void update(Subscription subscription){
			subscriptionRepository.save(subscription);
		}
	
	public ArrayList<Subscription> all(){

		return (ArrayList<Subscription>)subscriptionRepository.findAll();
		}

	public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	public Subscription findById(long id){
		return (Subscription) subscriptionRepository.findOne(id);

	}
	
	public void destroy(long id){
			subscriptionRepository.delete(id);

	}
	
	public Subscription findBySubscriptionName(String subscriptionName){

		return (Subscription) subscriptionRepository.findBySubscriptionName(subscriptionName);

	}


}
