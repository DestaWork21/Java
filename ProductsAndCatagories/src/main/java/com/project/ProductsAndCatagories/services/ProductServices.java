package com.project.ProductsAndCatagories.services;

import com.project.ProductsAndCatagories.models.Category;
import com.project.ProductsAndCatagories.models.Product;
import com.project.ProductsAndCatagories.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class ProductServices {
	private ProductRepository productRepository;

	public ProductServices(ProductRepository productRepository) {

		this.productRepository = productRepository;

	}

	public ArrayList<Product> getAll(){

		return productRepository.findAll();

		}

	public Product findProduct(Long id) {

		return productRepository.findOne(id);
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> listAvailableProducts(Category category){

		List<String> names = new ArrayList<String>();

		List<Product> current = category.getProducts();

		if(current.isEmpty()) {

			names.add("");

		}else {

			for (Product prod: current) {

				names.add(prod.getName());
			}
		}
		List<Product> products = productRepository.findByNameNotIn(names);
		return products;
	}
}