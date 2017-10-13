/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class ProfileController {
    @RequestMapping(value = "/user/profile")
    public ModelAndView showprofile(){
         ModelAndView mv = new ModelAndView();
        mv.setViewName("profile");
        return mv;
    }
    

}
