package com.project.javabelt.controllers;

import com.project.javabelt.models.Subscription;
import com.project.javabelt.models.User;
import com.project.javabelt.services.SubscriptionService;
import com.project.javabelt.services.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	// Member variables go here
	private UserService userService;
	private SubscriptionService subscriptionService;
	private long id;

	public UserController(UserService userService, SubscriptionService subscriptionService) {
		this.userService = userService;
		this.subscriptionService = subscriptionService;

	}

	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s, Model model) {

		if (s.getAttribute("id") != null) {
			model.addAttribute("user", userService.findById((long) s.getAttribute("id")));
			return "dashboard";
		} else {
			return "redirect:/register";

		}
	}

	@PostMapping("/login")

	public String login(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession s, Model model, RedirectAttributes red){

		User user = userService.findByEmail(email);

		if( user == null ){
			
			red.addFlashAttribute("err", "Invalid Credentials, Please try again");
			return "redirect:/register";

		}else{

			if( userService.isMatch( password ,user.getPassword() ) ){
				s.setAttribute("id",user.getId());
				if(user.isAdmin()==true){
					return "redirect:/admin";
				}else { 
				
				return "redirect:/subscription/new";
				}
				
				}
			else{
				model.addAttribute("password", "Invalid Password");
				return "redirect:/";

			}
				

		}	

	}

	@RequestMapping("/logout")

	public String logout(HttpSession s) {
		s.setAttribute("id", null);
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user, HttpSession s) {
		s.setAttribute("id", null);
		return "register";
	}

	@PostMapping("/register")

	public String create(@Valid @ModelAttribute("user") User user, BindingResult res, HttpSession session) {

		if (res.hasErrors()) {
			return "register";
		} else {
			userService.create(user);
			session.setAttribute("id", user.getId());

			return "redirect:/subscription/new";

		}

	}

}
