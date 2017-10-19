/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.repository.UserRepository;
import com.mycompany.librarymanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    
    //add
     public User addAuthor(User user){
        
        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return user;
    }
}
