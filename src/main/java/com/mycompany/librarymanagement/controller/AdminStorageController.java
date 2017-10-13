/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Storage;
import com.mycompany.librarymanagement.repository.StorageRepository;
import com.mycompany.librarymanagement.services.StorageService;
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
public class AdminStorageController {
    @Autowired
            StorageRepository storageRepository;
    
    @Autowired
            StorageService storageService;
    @RequestMapping("/adminstorage")
    public String showStorage(Model mm){
        List<Storage> storage = (List<Storage>) storageRepository.findAll();
        mm.addAttribute("liststorage", storage);
        return "adminstorage";
    }
//    SETUP STORAGE
    @RequestMapping("/addstorage")
    public String showaddStorage(Model mm){
        Storage storage  = new Storage();
        mm.addAttribute("storage", storage);
        return "adminaddstorage";
    }
    
    
    @RequestMapping(value = "/addstorage" , method = RequestMethod.POST)
    public String Addbook(
            Model mm ,
            @ModelAttribute("storage") Storage storage){
        
        try {
            storageService.addAuthor(storage);
        } catch (Exception e) {
            e.getMessage();
            return "addstorage";
        }
        return "redirect:/admin/adminstorage";
    }
    
}
