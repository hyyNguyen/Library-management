/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.model;

import com.mycompany.librarymanagement.entity.Book;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CartModel implements Serializable {

    private List<CartlineModel> cartLines = new ArrayList<>();
    private double totalPrice;

    public List<CartlineModel> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartlineModel> cartLines) {
        this.cartLines = cartLines;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
