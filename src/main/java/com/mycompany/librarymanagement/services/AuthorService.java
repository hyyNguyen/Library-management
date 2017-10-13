/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.Author;
import com.mycompany.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class AuthorService {
    @Autowired
            AuthorRepository authorRepository;
    
    //ADD AUTHOR
    public Author addAuthor(Author author){
        
        try {
            author = authorRepository.save(author);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return author;
    }
    
    //EDIT AUTHOR
    public Author getAuthorById(int id) {
        Author author = authorRepository.findOne(id);
        return  author;
    }
     public Author editauthor(Author author){
        
        try {
            author = authorRepository.save(author);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return author;
    }
    //DELETE AUTHOR
    
    public void deleteAuthor(int id){
        authorRepository.delete(id);
    }
    
   
}
