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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     public User addUsersignup(User user){
        
        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return user;
    }
    
}
