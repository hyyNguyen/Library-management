/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Author;
import com.mycompany.librarymanagement.repository.AuthorRepository;
import com.mycompany.librarymanagement.services.AuthorService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller

public class AdminAuthorController {
    @Autowired
            AuthorRepository authorRepository;
    @Autowired
            AuthorService  authorService;
    
    
    @RequestMapping( "/admin/adminauthor")
    public String showAuthor(Model mm){
        List<Author> author = (List<Author>) authorRepository.findAll();
        mm.addAttribute("listauthor", author);
        return "adminauthor";
    }
    
    //SETUP ADD AUTHOR
    @RequestMapping("/admin/addauthor")
    public String setupaddAuthror(Model mm){
        Author author = new Author();
        mm.addAttribute("author", author);
        return "adminaddauthor";
    }
    //ADD AUTHOR
    @RequestMapping(value = "/admin/addauthor" , method = RequestMethod.POST)
    public String Addbook(
            Model mm ,
            @ModelAttribute("author") Author author){
        
        try {
            authorService.addAuthor(author);
        } catch (Exception e) {
            e.getMessage();
            return "addauthor";
        }
        return "redirect:/admin/adminauthor";
    }
    //SETUP EDIT AUTHOR
    
//    @RequestMapping(value="/update", method = RequestMethod.GET)
//    public String updateUser(
//            @RequestParam(name = "idAuthor", required = true) int id, Model mm) {
//        
//        mm.addAttribute("author", authorService.getAuthorById(id));
//        return "redirect:/admin/addauthor";
//    }
//    
    
    
    //DELETE AUTHOR
    @RequestMapping("/delete" )
    public String deleteAuthor(
            @RequestParam(value = "idAuthor",required = true) int id){
        authorService.deleteAuthor(id);
        return "redirect:/admin/adminauthor";
    }
    
    
    
}
