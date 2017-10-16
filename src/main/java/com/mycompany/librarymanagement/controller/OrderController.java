/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Cart;
import com.mycompany.librarymanagement.entity.CartDetail;
import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.model.CartModel;
import com.mycompany.librarymanagement.repository.CartRepository;
import com.mycompany.librarymanagement.repository.CartdetailRepository;
import com.mycompany.librarymanagement.repository.UserRepository;
import com.mycompany.librarymanagement.services.AuthencationService;
import com.mycompany.librarymanagement.services.CartService;
import com.mycompany.librarymanagement.services.OrderService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ASUS
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartdetailRepository cartdetailRepository;
    @Autowired
    CartRepository cartRepository;
     @Autowired
    AuthencationService authencationService;
    
     @RequestMapping(value="/order", method = RequestMethod.GET)
    public String  setuporder(
            HttpServletRequest request,
            Model mm){
        
        try {
            CartModel myCart = cartService.getCartInSession(request);
            mm.addAttribute("cartList", myCart);
            
            
        } catch (Exception e) {
        }
        return "order";
    }
    
    //save order
     @RequestMapping(value="/order", method = RequestMethod.POST)
    public String  order(
            HttpServletRequest request,
            Model mm ,
            final RedirectAttributes redirectAttributes){
        
        try {
           
           
//            Nguoidung nguoidung = nguoidungRepository.findOne(1);
            CartModel cartInfo = cartService.getCartInSession(request);
            User user = authencationService.getUserInPrincipal();
            boolean rs = orderService.addOrder(user.getIdUser(),cartInfo);
            if(rs){
                cartService.removeCartInSession(request);
                cartService.storeLastOrderedCartInSession(request, cartInfo);
                return "redirect:/";
            }else{
                redirectAttributes.addFlashAttribute("messeger", "Đặt hàng thất bại");
                return "redirect:/order";
                
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/";
    }
    
    
    //A dmin home
     public void  Listorder(
            HttpServletRequest request,
            Model mm){
        
        try {
            List<CartDetail> phieumuonList = (List<CartDetail>) cartdetailRepository.findAll();
            mm.addAttribute("phieumuonList", phieumuonList);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public String showadmin(
            HttpServletRequest request,
            Model mm) {
        Listorder(request,mm);
        return "adminhome";
    }
}
