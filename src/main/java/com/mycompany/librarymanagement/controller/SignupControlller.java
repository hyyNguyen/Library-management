/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class SignupControlller {
    @Autowired
    SignupService signupService;
    @RequestMapping(value = "/signup")

    public String setupaddAuthror(Model mm){
        User user = new User();
        mm.addAttribute("signup", user);
        return "signup";
    }
      @RequestMapping(value = "/signup" , method = RequestMethod.POST)
    public String addSignup(
            Model mm ,
            @ModelAttribute("author") User user){
        
        try {
            signupService.addUsersignup(user);
        } catch (Exception e) {
            e.getMessage();
            return "signup";
        }
        return "redirect:/";
    }
}
