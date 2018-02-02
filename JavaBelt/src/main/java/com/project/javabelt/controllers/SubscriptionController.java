package com.project.javabelt.controllers;


import com.project.javabelt.models.Subscription;
import com.project.javabelt.models.User;
import com.project.javabelt.services.SubscriptionService;
import com.project.javabelt.services.UserService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SubscriptionController{
	private SubscriptionService subscriptionService;
	private UserService userService;
	public SubscriptionController(SubscriptionService subscriptionService,UserService userService){
		this.subscriptionService=subscriptionService;
		this.userService=userService;

	}
	
	@RequestMapping("/subscription/new")
	public String sub(@ModelAttribute("subscription") Subscription subscription, HttpSession s, Model model){
			ArrayList<User> users= userService.all();
			User user=userService.findById((long) s.getAttribute("id"));
			
			/*LocalDate today =LocalDate.now();
			today.toString();
			System.out.println(today.toString());*/
			
			
			
			
			ArrayList<Subscription> subscriptions=subscriptionService.all();
			model.addAttribute("users", users);
			model.addAttribute("subscriptions", subscriptions);
			model.addAttribute("user", user);
			
			if(user.getDueDate() !=null) {
				return "redirect:/profile";
			}
					
				
			return "subscription";
		
		}	
	
	@PostMapping("/subscription/new")
	public String sub(@RequestParam("dueDate") int dueDate, @RequestParam("subscription") long subscription,  Model model, HttpSession s){
		
		
		
		// user.setSubscription(subscription)
		
		/*LocalDate today =LocalDate.now();
		today.toString();
		
		LocalDate due=today.plusMonths(1);*/
		
		Subscription sub=subscriptionService.findById(subscription);
		User user=userService.findById((long) s.getAttribute("id"));
		Date date =userService.getNextDueDate(dueDate);
		user.setDueDate(date);
		userService.update(user);
		
		user.setSubscription(sub);
		userService.update(user);
				
		return "redirect:/profile";
		
	}
	@RequestMapping("/admin")
	public String show(@ModelAttribute("subscription") Subscription subscription, Model model, HttpSession s ){
		ArrayList<Subscription> subscriptions=subscriptionService.all();
		ArrayList<User> users= userService.all();
		model.addAttribute("subscriptions", subscriptions);
		//User user=userService.findById((long) s.getAttribute("id"));
		model.addAttribute("users", users);
		
		/*model.addAttribute("user", user);*/
		
		return "admin";
	}

	@PostMapping("/admin")
	public String create(@ModelAttribute("subscription") Subscription subscription, HttpSession s, Model model) {
		System.out.println(subscription.getSubscriptionName());
		subscriptionService.create(subscription);
			
		return "redirect:/admin"; 
					
	}
	@RequestMapping("/changeAvi/{id}")
	public String changeAvi(@PathVariable("id") long id) {
		
		Subscription toChange=subscriptionService.findById(id);
		
		if(toChange.isAvailable()==false) {
			toChange.setAvailable(true);
			
		}else {
			toChange.setAvailable(false);
		}
		
		subscriptionService.update(toChange);
		
		return "redirect:/admin";
	}
	@RequestMapping("/profile")
	public String profile( Model model, HttpSession s) {
			
			
		long id=(long)s.getAttribute("id");
		User person=userService.findById(id);
		model.addAttribute("person", person);
		
		return "profile";
		
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		subscriptionService.destroy(id);
		
		return "redirect:/admin";
		
	}
	
}
	

	
	
	
	
	









	
	
		
	
	

