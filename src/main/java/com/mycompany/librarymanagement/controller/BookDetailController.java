/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Book;
import com.mycompany.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
public class BookDetailController {
    
    @Autowired
    BookRepository bookRepository;
    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    public String showdetail(
            ModelMap mm,
            @RequestParam(value = "idbook",required = true) int idbook) {
        
       
        Book book = bookRepository.findOne(idbook);
        
        if(book!=null){
            mm.addAttribute("sach", book);
        }else{
            // neu ko tim thay tra ve trang nao
        }
        
        
        
        return "detail";
    }
}
