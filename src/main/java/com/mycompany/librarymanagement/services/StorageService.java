/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.Storage;
import com.mycompany.librarymanagement.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class StorageService {
    @Autowired
            StorageRepository storageRepository;
    
    public Storage addStorage(Storage storage){
        
        try {
            storage = storageRepository.save(storage);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return storage;
    }
    //EDIT storage
    public Storage getStorageId(int id) {
        Storage storage = storageRepository.findOne(id);
        return  storage;
    }
    //update storage
    public Storage editStorage(Storage storage){
        
        try {
            storage = storageRepository.save(storage);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return storage;
    }
    //delete
    public void deleteStorage(int id){
        storageRepository.delete(id);
    }
}
