package com.dproduction.service;

import java.util.List;

import com.dproduction.entity.Product;

public interface ProductService {

	void createProduct(Product product);
	
    List<Product> getAllProducts();
}
