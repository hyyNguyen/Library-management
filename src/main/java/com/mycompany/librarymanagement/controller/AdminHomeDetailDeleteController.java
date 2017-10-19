/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeDetailDeleteController {
    @Autowired
            CartDetailService cartDetailService;
    
    @RequestMapping(value="/deletecartdetail", method = RequestMethod.GET)
    public String updateAuthor(
            @RequestParam(name = "idCartdetail", required = true) int id, Model mm) {
        
        mm.addAttribute("cartdetail",cartDetailService.getCartDetailById(id) );
        return "adminhomedelete";
    }
    
}
