/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Book;
import com.mycompany.librarymanagement.model.CartModel;
import com.mycompany.librarymanagement.repository.BookRepository;
import com.mycompany.librarymanagement.services.CartService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
public class CartController {
    
    @Autowired
    CartService cartService;
    @Autowired
    BookRepository bookRepository;
    
        @RequestMapping(value = "/addCart" , method = RequestMethod.GET)
    public String addCart(
            HttpServletRequest request,
            ModelMap mm,
            @RequestParam(value = "idbook",required = true) int idsach) {
        
        Book sach = null;
        CartModel cartInfo = null;
       
        
        try {
            sach = bookRepository.findOne(idsach);
            if(sach!=null){
                cartInfo = cartService.getCartInSession(request);
                cartInfo.addSach(sach, 1);
            }
            
            CartModel myCart = cartService.getCartInSession(request);
            mm.addAttribute("cartList", myCart);
            
        } catch (Exception e) {
            e.getMessage();
        }
        return "cart";
    }
       @RequestMapping(value = {"/updateCart"}, method = RequestMethod.GET)
    public String updateCart(HttpServletRequest request,
            ModelMap mm,
            @RequestParam(value = "idsach",required = true) int idsach ,
            @RequestParam(value = "soluong",required = true) int soluong
    ) {
        try {

            CartModel cartInfo = cartService.getCartInSession(request);
            cartInfo.updateSach(idsach,soluong);
            CartModel myCart = cartService.getCartInSession(request);
            mm.addAttribute("cartList", myCart);
        } catch (Exception e) {
            e.getMessage();
        }
        
        // Redirect to shoppingCart page.
        return "cart";
    }
    //xoa
    @RequestMapping(value = "/deleteCart" , method = RequestMethod.GET)
    public String deleteCart(
            HttpServletRequest request,
            ModelMap mm,
            @RequestParam(value = "idsach",required = true) int idbook) {
        
        Book book = null;
        CartModel cartInfo = null;
        
        try {
            book = bookRepository.findOne(idbook);
            if(book!=null){
                cartInfo = cartService.getCartInSession(request);
                
                cartInfo.removeBook(book);
            }
            
            CartModel myCart = cartService.getCartInSession(request);
            mm.addAttribute("cartList", myCart);
            
        } catch (Exception e) {
            e.getMessage();
        }
        return "cart";
    }
}
