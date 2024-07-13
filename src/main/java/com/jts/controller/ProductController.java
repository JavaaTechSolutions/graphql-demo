package com.jts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jts.model.Product;
import com.jts.model.ProductInput;
import com.jts.model.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@QueryMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}

	@QueryMapping
	public List<Product> getProductsByName(@Argument String name) {
		return service.getProductsByName(name);
	}

	@MutationMapping
	public Product updatePrice(@Argument int id, @Argument float price) {
		return service.updatePrice(id, price);
	}

	@MutationMapping
	public Product addProduct(@Argument ProductInput product) {
		return service.addProduct(product);
	}
	
	@MutationMapping
	public Product updateProduct(@Argument ProductInput product) {
		return service.updateProduct(product);
	}
	
	@MutationMapping
	public String deleteProduct(@Argument int id) {
		return service.deleteProductById(id);

	}

}
