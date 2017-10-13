/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Book;
import com.mycompany.librarymanagement.entity.Category;
import com.mycompany.librarymanagement.repository.BookRepository;
import com.mycompany.librarymanagement.repository.CategoryRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
@Controller
public class HomeController {
    @Autowired
            BookRepository sachRepository;
    @Autowired
    CategoryRepository categoryRepository;
    
    @RequestMapping(value ={"/","/home"},  method = RequestMethod.GET)
    public String setuphome(ModelMap mm, HttpServletRequest request)throws Exception{
        
        try {
            List<Book> list = (List<Book>) sachRepository.findAll();
              List<Category> listcategory = (List<Category>) categoryRepository.findAll();
            mm.addAttribute("listSach", list);
            mm.addAttribute("listCategory", listcategory);
         
        }catch (Exception e) {
            e.getMessage();
        }
        return "home";
    }

    
}
