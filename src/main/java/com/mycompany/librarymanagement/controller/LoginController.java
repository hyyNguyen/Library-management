/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.repository.UserRepository;
import com.mycompany.librarymanagement.security.CustomAuthenticationProvider;
import com.mycompany.librarymanagement.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
@Controller
public class LoginController {
    @Autowired
            UserRepository userRepository;
   
    
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String setuplogin(Model mm
           ){
        return "login";
    }
    
    @RequestMapping(value = {"/loginError"}, method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("message", "Invalid account email or password.");
        return "login";
    }
}
