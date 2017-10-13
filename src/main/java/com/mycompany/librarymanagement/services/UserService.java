/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    
    public User findbyEmailandPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
    
}
