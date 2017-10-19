/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.model.CartModel;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CartService {

    public static CartModel getCartInSession(HttpServletRequest request) {

        // Get Cart from Session.
        CartModel cartInfo = (CartModel) request.getSession().getAttribute("myCart");

        if (cartInfo == null) {
            cartInfo = new CartModel();
            request.getSession().setAttribute("myCart", cartInfo);
        }

        return cartInfo;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

}
