package com.project.ProductsAndCatagories.controllers;

import com.project.ProductsAndCatagories.models.Category;
import com.project.ProductsAndCatagories.models.Product;
import com.project.ProductsAndCatagories.services.CategoryServices;
import com.project.ProductsAndCatagories.services.ProductServices;
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


@Controller

@RequestMapping("/category")

public class CategoryController {

	@Autowired

	private ProductServices productServices;
	private CategoryServices categoryServices;

	public CategoryController(CategoryServices categoryServices) {
		this.categoryServices = categoryServices;
	}

	@RequestMapping("/new")
	public String createCategory(@ModelAttribute("category") Category category) {
		return "newCategory";
	}
	@PostMapping("/new")
	public String addCategory (@Valid @ModelAttribute("category") Category category,BindingResult result) {
		if(result.hasErrors()) {
					return "newCategory";

		}
		else {

			categoryServices.addCategory(category);

			return "redirect:/";

		}

	}

	@RequestMapping("/{id}")

	public String createCategoryProduct(Model model, @PathVariable("id") Long id) {

		model.addAttribute("products", productServices.listAvailableProducts(categoryServices.findCategory(id)));

		model.addAttribute("category", categoryServices.findCategory(id));

		return "newCatPro";

	}

	@PostMapping("/{id}")

	public String addCategoryProduct(Model model, @PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {

		Product product = productServices.findProduct(productId);

		Category category = categoryServices.findCategory(categoryId);

		category.getProducts().add(product);

		categoryServices.addCategory(category);

		

		return "redirect:/";

	}
	
}
