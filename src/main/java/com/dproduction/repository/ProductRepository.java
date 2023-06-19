package com.dproduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dproduction.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
