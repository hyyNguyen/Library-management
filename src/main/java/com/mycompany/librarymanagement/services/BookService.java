/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.services;

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
import com.mycompany.librarymanagement.util.HibernateUtil;
import com.mysql.cj.api.Session;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ASUS
 */
@Service
public class BookService {
    @Autowired
            BookRepository bookRepository;
    @Autowired
            AuthorRepository authorRepository;
    @Autowired
            CategoryRepository categoryRepository;
    @Autowired
            PublishingCompanyRepository publishingCompanyRepository;
    @Autowired
            StorageRepository storageRepository;
    
    public Book addBook(Book book){
        
        try{
            Author author = authorRepository.findOne(book.getIdAuthor().getIdAuthor());
            Category category = categoryRepository.findOne(book.getIdCategory().getIdCategory());
            PublishingCompany publishingcompany = publishingCompanyRepository.findOne(book.getIdPublishingcompany().getIdPublishingcompany());
            Storage storage= storageRepository.findOne(book.getIdStorage().getIdStorage());
            
            book.setIdAuthor(author);
            book.setIdCategory(category);
            book.setIdPublishingcompany(publishingcompany);
            book.setIdStorage(storage);
            book = bookRepository.save(book);
        }
        catch(Exception e) {
            e.getMessage();
            return null;
        }
        return book;
    }
    
      public Book getBookById(int id) {
        Book book = bookRepository.findOne(id);
        return  book;
    }
      
      
    public void deleteBook(int id){
        bookRepository.delete(id);
    }
    
  
}
