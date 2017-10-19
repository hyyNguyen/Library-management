/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.model;

import com.mycompany.librarymanagement.entity.Book;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ASUS
 */
public class CartlineModel implements Serializable {

    private Book book;
    private int quantity;
    private int numberCanOrder;
    
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date NgayMuon;

    private String ngayTra;

    public CartlineModel() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumberCanOrder() {
        return numberCanOrder;
    }

    public void setNumberCanOrder(int numberCanOrder) {
        this.numberCanOrder = numberCanOrder;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

}
