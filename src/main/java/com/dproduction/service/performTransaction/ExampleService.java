package com.dproduction.service.performTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dproduction.entity.User;

import com.dproduction.service.UserService;

@Service
public class ExampleService {

    @Autowired
    private UserService userService;

    
    public void performTransaction() {
    	
    	
        User user1 = new User("John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");

        // Les opérations suivantes seront exécutées dans une transaction
        userService.createUser(user1);
        userService.createUser(user2);
        userService.updateUser(user1);

        // Si une exception se produit, la transaction sera annulée et tous les changements seront annulés
      
        /*
        if (condition) {
            throw new RuntimeException("An error occurred");
        }
        */

        userService.deleteUser(user2.getId());
    }
}

