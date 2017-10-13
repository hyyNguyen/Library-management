/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "cart_detail")
@NamedQueries({
    @NamedQuery(name = "CartDetail.findAll", query = "SELECT c FROM CartDetail c")})
public class CartDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCart_detail")
    private Integer idCartdetail;
    @Column(name = "borrowing_day")
    @Temporal(TemporalType.DATE)
    private Date borrowingDay;
    @Column(name = "pay_day")
    @Temporal(TemporalType.DATE)
    private Date payDay;
    @Column(name = "final_pay_day")
    @Temporal(TemporalType.DATE)
    private Date finalPayDay;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "indemnification")
    private Float indemnification;
    @JoinColumn(name = "idBook", referencedColumnName = "idBook")
    @ManyToOne
    private Book idBook;
    @JoinColumn(name = "idCart", referencedColumnName = "idcart")
    @ManyToOne
    private Cart idCart;

    public CartDetail() {
    }

    public CartDetail(Integer idCartdetail) {
        this.idCartdetail = idCartdetail;
    }

    public Integer getIdCartdetail() {
        return idCartdetail;
    }

    public void setIdCartdetail(Integer idCartdetail) {
        this.idCartdetail = idCartdetail;
    }

    public Date getBorrowingDay() {
        return borrowingDay;
    }

    public void setBorrowingDay(Date borrowingDay) {
        this.borrowingDay = borrowingDay;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public Date getFinalPayDay() {
        return finalPayDay;
    }

    public void setFinalPayDay(Date finalPayDay) {
        this.finalPayDay = finalPayDay;
    }

    public Float getIndemnification() {
        return indemnification;
    }

    public void setIndemnification(Float indemnification) {
        this.indemnification = indemnification;
    }

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartdetail != null ? idCartdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartDetail)) {
            return false;
        }
        CartDetail other = (CartDetail) object;
        if ((this.idCartdetail == null && other.idCartdetail != null) || (this.idCartdetail != null && !this.idCartdetail.equals(other.idCartdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.librarymanagement.entity.CartDetail[ idCartdetail=" + idCartdetail + " ]";
    }
    
}
