/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.Category;
import com.mycompany.librarymanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
    public Category addCategory(Category category){
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return category;
    }
    
    public void deleteCategory(int id){
        categoryRepository.delete(id);
    }
}
