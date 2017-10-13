/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Author;
import com.mycompany.librarymanagement.entity.Book;
import com.mycompany.librarymanagement.entity.Category;
import com.mycompany.librarymanagement.entity.PublishingCompany;
import com.mycompany.librarymanagement.entity.Storage;
import com.mycompany.librarymanagement.repository.AuthorRepository;
import com.mycompany.librarymanagement.repository.BookRepository;
import com.mycompany.librarymanagement.repository.CategoryRepository;
import com.mycompany.librarymanagement.repository.PublishingCompanyRepository;
import com.mycompany.librarymanagement.repository.StorageRepository;
import com.mycompany.librarymanagement.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class AdminBookController {
    @Autowired
            BookService bookService;
    @Autowired
            AuthorRepository authorRepository;
    @Autowired
            CategoryRepository categoryRepository;
    @Autowired
            PublishingCompanyRepository publishingCompanyRepository;
    @Autowired
            StorageRepository storageRepository;
    @Autowired
            BookRepository bookRepository;
    
//    setup book
    @RequestMapping("/adminbook")
    public String showbook(Model mm){
        List<Book> book = (List<Book>) bookRepository.findAll();
        mm.addAttribute("listbook", book);
        return "adminbook";
    }
    
//    setup add
    @RequestMapping(value = "/addbook" , method = RequestMethod.GET)
    public String setupAddbook(
            Model mm){
        
        List<Author> author = (List<Author>) authorRepository.findAll();
        List<PublishingCompany> publishingcompany = (List<PublishingCompany>) publishingCompanyRepository.findAll();
        List<Storage> storage = (List<Storage>) storageRepository.findAll();
        List<Category> category = (List<Category>) categoryRepository.findAll();
        
        Book book = new Book();
        
        mm.addAttribute("listauthor", author);
        mm.addAttribute("listpublishingcompany", publishingcompany);
        mm.addAttribute("liststorage", storage);
        mm.addAttribute("listcategory", category);
        
        
        mm.addAttribute("listbook", book);
        
        return "adminaddbook";
    }
    @RequestMapping(value = "/addbook" , method = RequestMethod.POST)
    public String Addbook(
            Model mm ,
            @ModelAttribute("listbook") Book book){
        
        try {
            bookService.addBook(book);
            
        } catch (Exception e) {
            e.getMessage();
            return "adminaddbook";
        }
        
        return "redirect:/admin/adminbook";
    }
//    @RequestMapping("/delete" )
//     public String deletebook(
//                @RequestParam(value = "idBook",required = true) int id){
//         bookService.deleteBook(id);
//          return "redirect:/admin/adminbook";
//     }
}
