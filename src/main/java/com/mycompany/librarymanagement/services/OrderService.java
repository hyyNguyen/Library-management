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
import com.mycompany.librarymanagement.repository.UserRepository;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
            UserRepository userRepository;
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
            cart = cartRepository.save(cart);
            
            for(int i = 0 ; i< cartInfoTemp.getCartLines().size();i++){
                
                CartDetail cartdetail = new CartDetail();
                
                cartdetail.setIdCart(cart);
                cartdetail.setIdBook(cartInfoTemp.getCartLines().get(i).getBook());
                
                // so luong dat
                cartdetail.setBorrowingDay(new Date());
                cartdetail.setPayDay(cartInfoTemp.getCartLines().get(i).getNgayTra());
                
                cartdetailRepository.save(cartdetail);
            }
            
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }
    
}
