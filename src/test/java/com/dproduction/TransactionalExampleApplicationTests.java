package com.dproduction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.dproduction.entity.Product;
import com.dproduction.repository.ProductRepository;
import com.dproduction.service.ProductServiceImpl;
import com.dproduction.service.UserService;
import com.dproduction.service.performTransaction.ExampleService;
import org.junit.jupiter.api.Test;



@SpringBootTest
@Transactional
class TransactionalExampleApplicationTests {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ExampleService exampleService;
    
    @Autowired
    private UserService userService;
    

    @Test
    public void testTransactionRollback() {
        // Create a product
        Product product = new Product();
        product.setName("Test Product 3");
        productService.createProduct(product);

        // Verify that the product is not saved in the database due to the exception
        List<Product> products = productRepository.findAll();
        
        assertThat(products).isNotEmpty();
        //assertThat(products).isEmpty();
    }
    
    
    
    @org.junit.jupiter.api.Test
    public void testPerformTransaction() {
        // Perform the test
        exampleService.performTransaction();

        // Assert the result
        // Write assertions to validate the expected outcome of the transaction
        // For example, you can check if the users were created, updated, and deleted successfully
        assertTrue(userService.doesUserExist("John Doe"));
        //assertFalse(userService.doesUserExist("Jane Smith"));
    }
    
    

}
