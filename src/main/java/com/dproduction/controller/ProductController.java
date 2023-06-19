package com.dproduction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dproduction.entity.Product;
import com.dproduction.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

 private final ProductServiceImpl productService;

 public ProductController(ProductServiceImpl productService) {
     this.productService = productService;
 }

 @PostMapping
 public ResponseEntity<String> createProduct(@RequestBody Product product) {
     productService.createProduct(product);
     return ResponseEntity.ok("Product created successfully");
 }

 @GetMapping
 public ResponseEntity<List<Product>> getAllProducts() {
     List<Product> products = productService.getAllProducts();
     return ResponseEntity.ok(products);
 }
}