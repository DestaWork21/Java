package com.project.beltreview.controllers;


import com.project.beltreview.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/*") // Wildcard all routes.
public class RouteController{
	private UserService userService;
	public RouteController(UserService userService){
		this.userService=userService;	}
	
	@RequestMapping("")
	public String register(HttpSession session, HttpServletRequest req){		
		
		if(session.getAttribute("id") !=null){
		return "redirect:/dashboard";
		} 
		else {
			return "redirect:/register";
		}	
	}	
}