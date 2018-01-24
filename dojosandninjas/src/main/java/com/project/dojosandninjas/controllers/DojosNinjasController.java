package com.project.dojosandninjas.controllers;

import com.project.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/")

public class DojosNinjasController{
	@Autowired
	private DojoService dojoService;
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("dojos",dojoService.all());
		return "index";
	}

}
