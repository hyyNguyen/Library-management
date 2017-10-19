/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Category;
import com.mycompany.librarymanagement.repository.CategoryRepository;
import com.mycompany.librarymanagement.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class AdminCategoryController {
    @Autowired
            CategoryService categoryService;
    @Autowired
            CategoryRepository categoryRepository;
    
    
      //list
    @RequestMapping("/admincategory")
    public String showCategory(Model mm){
        List<Category> category = (List<Category>) categoryRepository.findAll();
        mm.addAttribute("listcategory", category);
        return "admincategory";
    }
     //SETUP  ADD CATEGORY
    
    @RequestMapping("/addcategory")
    public String setupCategory(Model mm){
        Category category = new Category();
        mm.addAttribute("category", category);
        return "adminaddcategory";
    }
    //SAVE CATEGORY
    @RequestMapping(value = "/addcategory" , method = RequestMethod.POST)
    public String AddCategory(
            Model mm ,
            @ModelAttribute("category") Category category){
        
        try {
            categoryService.addCategory(category);
        } catch (Exception e) {
            e.getMessage();
            return "addcategory";
        }
        return "redirect:/admin/admincategory";
        
    }
    //delete
    @RequestMapping("/deletecategory")
    public String deleteCategory(
            @RequestParam(value="idCategory", required = true)int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/admincategory";
    }
    //Edit
    @RequestMapping(value="/updatecategory", method = RequestMethod.GET)
    public String updateCategory(
            @RequestParam(name = "idCategory", required = true) int id, Model mm) {
        mm.addAttribute("category", categoryService.getCategoryId(id));
        return "adminaddcategory";
    }
    
    @RequestMapping(value="/updatecategory", method = RequestMethod.POST)
    public String addupdateCategory(
            Model mm, 
            @ModelAttribute("category") Category category){
        
        try {
            categoryService.addCategory(category);
        } catch (Exception e) {
            e.getMessage();
            return "addcategory";
        }
        
        return "redirect:/admin/admincategory";
        
    }
     
 }
