/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.CartDetail;
import com.mycompany.librarymanagement.repository.CartdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailService {
    
    
     @Autowired
            CartdetailRepository cartdetailRepository;
    public void deleteCartDetail(int id){
        cartdetailRepository.delete(id);
    }
    
       public CartDetail getCartDetailById(int id) {
        CartDetail cartdetail = cartdetailRepository.findOne(id);
        return  cartdetail;
    }
}
