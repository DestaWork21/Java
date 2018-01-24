package com.project.DriversLicense.controllers;

import com.project.DriversLicense.models.Person;
import com.project.DriversLicense.models.License;
import com.project.DriversLicense.services.LicenseService;
import com.project.DriversLicense.services.PersonService;
import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/license")

public class LicenseController{	
	@Autowired
	private LicenseService licenseService;

	@Autowired
	private PersonService personService;

	public LicenseController(LicenseService licenseService,PersonService personService){

		this.licenseService = licenseService;
		this.personService =personService;

	}


	@RequestMapping("/new")

	public String _new(@ModelAttribute("license") License license,Model model){
		ArrayList<Person> people = (ArrayList<Person>)personService.all();
		
		if(people != null){
			model.addAttribute("persons",people);	
		}else{
			model.addAttribute("persons",new ArrayList<Person>());
		}
		
		return "new_license";
	}

	
	@PostMapping("/new")

	public String create(@Valid @ModelAttribute("license") License license,BindingResult res,RedirectAttributes re){

		if(res.hasErrors()){

			re.addFlashAttribute("errs",res.getAllErrors());

			return "redirect:/license/new";

		}else{
			
			licenseService.create(license);

			return "redirect:/";

		}

	}


	

}

