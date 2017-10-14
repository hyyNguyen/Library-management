/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.entity.Cart;
import com.mycompany.librarymanagement.entity.CartDetail;
import com.mycompany.librarymanagement.model.CartModel;
import com.mycompany.librarymanagement.repository.CartRepository;
import com.mycompany.librarymanagement.repository.CartdetailRepository;
import com.mycompany.librarymanagement.repository.CategoryRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderService {
    @Autowired
            UserService uerService;
    @Autowired
            CartRepository cartRepository;
    @Autowired
    CartdetailRepository cartdetailRepository;
    
    public boolean addOrder(int iduser, CartModel cartInfo){
        
        CartModel cartInfoTemp;
        
        try {
            cartInfoTemp = (CartModel) ServicesCloneObject.clone(cartInfo);
            
            Cart cart = new Cart();
            cart.setIdUser(uerService.findbyID(iduser));
            //   phieumuon.setIdnguoichomuon(thuthu);
            
            cart= cartRepository.save(cart);
            
            for(int i = 0 ; i< cartInfoTemp.getCartLines().size();i++){
                
                
                
                CartDetail cartdetail = new CartDetail();
                
                cartdetail.setIdCart(cart);
//                cartdetail.setIdsach(cartInfoTemp.getCartLines().get(i).getSach());
                cartdetail.setIdBook(cartInfoTemp.getCartLines().get(i).getBook());
                // so luong dat
               
//                chitietphieumuon.setNgaymuon(new Date());
                cartdetail.setBorrowingDay(new Date());


                cartdetailRepository.save(cartdetail);
                            }
            
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }
    
    
}
