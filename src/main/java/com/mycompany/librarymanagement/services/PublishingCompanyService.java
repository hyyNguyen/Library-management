/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.PublishingCompany;
import com.mycompany.librarymanagement.repository.PublishingCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PublishingCompanyService {
    @Autowired
    PublishingCompanyRepository publishingCompanyRepository;
    
      public PublishingCompany addPublishingCompany(PublishingCompany publishingcompany){
        
        try {
            publishingcompany = publishingCompanyRepository.save(publishingcompany);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return publishingcompany;
    }
}
