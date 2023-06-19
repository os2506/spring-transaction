package com.dproduction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dproduction.entity.Product;
import com.dproduction.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
        //throw new RuntimeException("Simulating an exception");
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

//@Transactional(propagation = Propagation.REQUIRED)
//@Transactional(propagation = Propagation.REQUIRES_NEW)
//@Transactional(propagation = Propagation.NESTED)
//@Transactional(isolation = Isolation.READ_COMMITTED)
//@Transactional(rollbackFor = Exception.class)

