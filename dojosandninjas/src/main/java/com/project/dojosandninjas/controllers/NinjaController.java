package com.project.dojosandninjas.controllers;

import com.project.dojosandninjas.models.Ninja;
import com.project.dojosandninjas.services.DojoService;
import com.project.dojosandninjas.services.NinjaService;

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

@RequestMapping("/ninjas")

public class NinjaController {

	@Autowired

	private NinjaService ninjaService;

	@Autowired

	private DojoService dojoService;

	

	public NinjaController(NinjaService ninjaService){

		this.ninjaService = ninjaService;

	}

	

	@RequestMapping("/new")

	public String _new(Model model){

		model.addAttribute("ninja",new Ninja());

		model.addAttribute("dojos",dojoService.all());

		return "new_ninja";

	}

	

	@PostMapping("/new")

	public String create(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult res,RedirectAttributes re,Model model){

		if(res.hasErrors()){

			re.addFlashAttribute("errs",res.getAllErrors());

		}else{

			ninjaService.create(ninja);

		}

		

		return "redirect:/";

	}

}
