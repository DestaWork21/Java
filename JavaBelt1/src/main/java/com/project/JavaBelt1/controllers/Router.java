package com.project.JavaBelt1.controllers;

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
		return "redirect:/dashboard";
		} 
		else {
			return "redirect:/register";
		}	
	}	
}

