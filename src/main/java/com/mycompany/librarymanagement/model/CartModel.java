/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.model;

import com.mycompany.librarymanagement.entity.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CartModel {
       private int index;
    private List<CartlineModel> cartLines = new ArrayList<CartlineModel>();
    private double totalPrice;
    
    //tìm 1 cartline thông qua id sp

    private CartlineModel findLineByCode(int id) {
        for (CartlineModel line : this.cartLines) {
            if (line.getBook().getIdBook() == id) {
                return line;
            }
        }
        return null;
    }
    
    //thêm 1 cartline vào cart

    public void addSach(Book sach, int quantity) {

        try {

            CartlineModel line = this.findLineByCode(sach.getIdBook());

            if (line == null) {
                line = new CartlineModel();
                line.setQuantity(0);
                line.setBook(sach);
                this.cartLines.add(line);
            }
            int newQuantity = line.getQuantity() + quantity;
            if (newQuantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(newQuantity);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void updateSach(int code, int quantity) {
        CartlineModel line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }


//update số lượng của tất cả line
    public void updateQuantity(CartModel cartForm) {
        if (cartForm != null) {
            List<CartlineModel> lines = cartForm.getCartLines();
            for (CartlineModel line : lines) {
//                this.updateQuantity(line.getBook().getIdBook(), line.getQuantity());
        this.updateSach(line.getBook().getIdBook(), line.getQuantity());
            }
        }

    }
     //xóa 1 cartline trong cart
    public void removeBook(Book sach) {
        CartlineModel line = this.findLineByCode(sach.getIdBook());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

    

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

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
