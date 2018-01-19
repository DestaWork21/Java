package com.project.Language.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.Language.models.Language;
import com.project.Language.services.LanguageService;

@Controller

@RequestMapping("/")

public class HomeController {



	private final LanguageService  LanguageService;

	public HomeController(LanguageService LanguageService) {

		this.LanguageService = LanguageService;

	}



	@RequestMapping("")

	public String index(Model model,@ModelAttribute("lang")Language language) {

		List<Language> languages = LanguageService.allLanguages();

		model.addAttribute("languages", languages);

		return "index";

	}



	@RequestMapping("/language/{id}")

	public String language(@PathVariable("id") Long id, Model model) {

		Language language= LanguageService.findLanguageById(id);

		if (language != null) {

			model.addAttribute("lang",language);

			return "language";

		}else {

			return "redirect:/";

		}

	}



	@PostMapping("/language/new")

	public String createLanguage(@Valid @ModelAttribute("lang") Language language, BindingResult result,Model model) {

		if(result.hasErrors()) {

			List<Language> languages = LanguageService.allLanguages();

			model.addAttribute("languages", languages);

			return "index";

		}else {

			LanguageService.addLanguage(language);

			return "redirect:/";

		}

	}

	@RequestMapping("/language/edit/{id}")

	public String editLanguage(@PathVariable("id") Long id, Model model) {

		Language language= LanguageService.findLanguageById(id);

		if (language != null) {

			model.addAttribute("lang",language);

			return "editLanguage";

		}else {

			return "redirect:/";

		}

	}

	@PostMapping(value="/language/update/{id}")

	public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("lang") Language language, BindingResult result) {

		if (result.hasErrors()) {

				return "redirect:/language/edit/{id}";

		}else {

			LanguageService.updateLanguage(language);

			return "redirect:/";

		}

	}

	@RequestMapping(value="/language/delete/{id}")

	public String destroyLanguage(@PathVariable("id") Long id ) {

		LanguageService.destroyLanguage(id);

		return"redirect:/";

	}


}