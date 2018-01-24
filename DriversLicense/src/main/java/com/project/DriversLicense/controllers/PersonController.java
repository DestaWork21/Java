package com.project.DriversLicense.controllers;

import com.project.DriversLicense.models.Person;
import com.project.DriversLicense.services.PersonService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

@RequestMapping("/persons")

public class PersonController {
	//Member variables go here
	private PersonService personService;
	public PersonController(PersonService personService){
		this.personService = personService;
	}

	@RequestMapping("/{id}")

	public String show(@PathVariable("id") long id,Model model){
		model.addAttribute("person",personService.findByIndex(id));
		return "show_person";
	}

	@RequestMapping("/new")

	public String _new(Model model){

		model.addAttribute("person",new Person());

		return "new_person";

	}

	@PostMapping("/new")

	public String create(@Valid @ModelAttribute("person") Person person,BindingResult res,RedirectAttributes red,Model model){		

		if(res.hasErrors()){

			red.addFlashAttribute("errs",res.getAllErrors());

			return "redirect:/persons/new";

		}else{

			personService.create(person);

			return "redirect:/license/new";

		}

	}

}
