/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.PublishingCompany;
import com.mycompany.librarymanagement.repository.PublishingCompanyRepository;
import com.mycompany.librarymanagement.services.PublishingCompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class AdminPublishingCompanyController {
    
    @Autowired
    PublishingCompanyRepository publishingCompanyRepository;
    @Autowired
    PublishingCompanyService publishingCompanyService;
    
    @RequestMapping("/adminpublishingcompany")
    public String showPublishingCompany(Model mm){
        List<PublishingCompany> publishingcompany = (List<PublishingCompany>) publishingCompanyRepository.findAll();
        mm.addAttribute("listpublishingcompany", publishingcompany);
        return "adminpublishingcompany";
    }
        
//    SETSUP ADD
     @RequestMapping("/addpublishingcompany")
    public String showaddPublishingcompany(Model mm){
        PublishingCompany publishingcompany  = new PublishingCompany();
        mm.addAttribute("publishingcompany", publishingcompany);
        return "adminaddpublishingcompany";
    }
    
    
    @RequestMapping(value = "/addpublishingcompany" , method = RequestMethod.POST)
    public String AddPublishingcompany(
            Model mm ,
            @ModelAttribute("publishingcompany") PublishingCompany publishingcompany){
        
        try {
            publishingCompanyService.addPublishingCompany(publishingcompany);
        } catch (Exception e) {
            e.getMessage();
            return "addpublishingcompany";
        }
        return "redirect:/admin/adminpublishingcompany";
    }
    
}
