/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.User;
import java.io.Serializable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthencationService implements  Serializable {
    private static final long serialVersionUID = 1L;
    
    public User getUserInPrincipal() {

        try {
            com.mycompany.librarymanagement.entity.User userSpringAuthencation =  (com.mycompany.librarymanagement.entity.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userSpringAuthencation;
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    public org.springframework.security.core.userdetails.User getPrincipal() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
