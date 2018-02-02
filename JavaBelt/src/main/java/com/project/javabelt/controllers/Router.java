package com.project.javabelt.controllers;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router<HttpSesssion>{
 	public Router(){

 	}
	
 	@RequestMapping("")
 	public String redirect(HttpSession session){		
		
 		if(session.getAttribute("id") !=null){
			
 		return "redirect:/subscription";
 		} 
 		else {
			return "redirect:/register";
		}	
 	}	
 }