/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.CartDetail;
import com.mycompany.librarymanagement.repository.CartdetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller

public class AdminHomeController {
    @Autowired
            CartdetailRepository cartdetailRepository;
    
    //setup adminhome
    @RequestMapping( "/admin/adminhome")
    public String showCartDetail(Model mm){
        List<CartDetail> cartdetail = (List<CartDetail>) cartdetailRepository.findAll();
        mm.addAttribute("listcartdetail", cartdetail);
        return "adminhome";
    }
    
    
    
}
