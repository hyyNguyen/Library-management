/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.controller;

import com.mycompany.librarymanagement.entity.Book;
import com.mycompany.librarymanagement.entity.CartDetail;
import com.mycompany.librarymanagement.model.CartModel;
import com.mycompany.librarymanagement.model.CartlineModel;
import com.mycompany.librarymanagement.repository.BookRepository;
import com.mycompany.librarymanagement.repository.CartRepository;
import com.mycompany.librarymanagement.repository.CartdetailRepository;
import com.mycompany.librarymanagement.services.CartService;
import com.mycompany.librarymanagement.services.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
            CartdetailRepository cartdetailRepository;
    @Autowired
            UserService uerService;
    @Autowired
            CartRepository cartRepository;
    
    @RequestMapping(value = "/addCart", method = RequestMethod.GET)
    public String addCart(
            HttpServletRequest request,
            Model model,
            @RequestParam(value = "idbook", required = true) int idsach) {
        
        CartModel cartInfo = CartService.getCartInSession(request);
        if (idsach > 0) {
            Book book = bookRepository.findOne(idsach);
            if (book != null) {
                if (cartInfo.getCartLines().size() > 0) {
                    boolean isExist = false;
                    for (CartlineModel cartLine : cartInfo.getCartLines()) {
                        if (cartLine.getBook().getIdBook() == idsach) {
                            cartLine.setQuantity(cartLine.getQuantity() + 1);
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        CartlineModel cartlineModel = new CartlineModel();
                        cartlineModel.setBook(book);
                        cartlineModel.setQuantity(1);
                        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = new Date();
                        cartlineModel.setNgayTra(sdfr.format(date));
                        cartInfo.getCartLines().add(cartlineModel);
                    }
                } else {
                    CartlineModel cartlineModel = new CartlineModel();
                    cartlineModel.setBook(book);
                    cartlineModel.setQuantity(1);
                    SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = new Date();
                    cartlineModel.setNgayTra(sdfr.format(date));
                    List<CartlineModel> list = new ArrayList<>();
                    list.add(cartlineModel);
                    cartInfo.setCartLines(list);
                }
                request.getSession().setAttribute("myCart", cartInfo);
            }
        }
        return "redirect:/cart";
    }
    
    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String showCart(HttpServletRequest request, Model model) {
        CartModel cartInfo = CartService.getCartInSession(request);
        model.addAttribute("cartInfo", cartInfo);
        return "cart";
    }
    
    @RequestMapping(value = {"/updateBook"}, method = RequestMethod.POST)
    public String updateCart(HttpServletRequest request,
            @ModelAttribute(value = "idbook") int idsach,
            @ModelAttribute(value = "soluong") int soluong,
            @ModelAttribute(value = "ngaytra") String ngaytra) {
        CartModel cartInfo = CartService.getCartInSession(request);
        if (cartInfo != null) {
            if (cartInfo.getCartLines().size() > 0) {
                for (CartlineModel cartLine : cartInfo.getCartLines()) {
                    if (cartLine.getBook().getIdBook() == idsach) {
                        cartLine.setNgayTra(ngaytra);
                        cartLine.setQuantity(soluong);
                        break;
                    }
                }
                request.getSession().setAttribute("myCart", cartInfo);
            }
        }
        return "redirect:/cart";
    }
    
    //xoa
    @RequestMapping(value = "/deleteCart/{idsach}", method = RequestMethod.GET)
    public String deleteCart(
            HttpServletRequest request,
            @PathVariable(value = "idsach", required = true) int idsach) {
        CartModel cartInfo = CartService.getCartInSession(request);
        if (cartInfo != null) {
            if (cartInfo.getCartLines().size() > 0) {
                for (int i = 0; i < cartInfo.getCartLines().size(); i++) {
                    if (cartInfo.getCartLines().get(i).getBook().getIdBook() == idsach) {
                        cartInfo.getCartLines().remove(i);
                        break;
                    }
                }
                request.getSession().setAttribute("myCart", cartInfo);
            }
        }
        return "redirect:/cart";
    }
    
    //order
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String OrderCart(
            HttpServletRequest request,
            final RedirectAttributes redirectAttributes) throws ParseException {
        CartModel cartInfo = CartService.getCartInSession(request);
        for (int i = 0; i < cartInfo.getCartLines().size(); i++) {
            if (cartInfo != null) {
                CartDetail cartdetail = new CartDetail();
                
                
                cartdetail.setIdBook(cartInfo.getCartLines().get(i).getBook());
                cartdetail.setIndemnification((float)cartInfo.getCartLines().get(i).getQuantity());
                cartdetail.setBorrowingDay(new Date());
                
//                 String string = cartInfo.getCartLines().get(i).getNgayTra();
                 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                 Date date = formatter.parse(cartInfo.getCartLines().get(i).getNgayTra());
                 cartdetail.setPayDay(date);
              
                    cartdetailRepository.save(cartdetail);
            }
            else{
                redirectAttributes.addFlashAttribute("messeger", "Đặt hàng thất bại");
                return "redirect:/order";
            }
            
        }
//                xoa sesion
        cartService.removeCartInSession(request);
        return "redirect:/";
    }
}
