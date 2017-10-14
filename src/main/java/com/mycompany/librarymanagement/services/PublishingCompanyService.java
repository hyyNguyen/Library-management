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
    
    //add PublishingCompany
    public PublishingCompany addPublishingCompany(PublishingCompany publishingcompany){
        
        try {
            publishingcompany = publishingCompanyRepository.save(publishingcompany);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return publishingcompany;
    }
    //EDIT PublishingCompany
    public PublishingCompany getPublishingCompanyId(int id) {
        PublishingCompany publishingcompany = publishingCompanyRepository.findOne(id);
        return  publishingcompany;
    }
    //update PublishingCompany
    public PublishingCompany editPublishingCompany(PublishingCompany publishingcompany){
        
        try {
            publishingcompany = publishingCompanyRepository.save(publishingcompany);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return publishingcompany;
    }
    //delete PublishingCompany
    public void deletePublishingCompany(int id){
        publishingCompanyRepository.delete(id);
    }
    
    
}
