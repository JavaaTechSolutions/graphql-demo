package com.jts.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public List<Product> getProductsByName(String name) {
		return repository.findByName(name);
	}
	
	public Product updatePrice(int id, float price) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found with id " + id));
		
		existingProduct.setPrice(price);
		
		repository.save(existingProduct);
		
		return existingProduct;
	}

}
