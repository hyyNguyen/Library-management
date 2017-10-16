/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "cart")
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcart")
    private Integer idcart;
    @OneToMany(mappedBy = "idCart")
    private Collection<CartDetail> cartDetailCollection;
    @JoinColumn(name = "idUser")
    //, referencedColumnName = "id_user"
    @ManyToOne
    private User idUser;

    public Cart() {
    }

    public Cart(Integer idcart) {
        this.idcart = idcart;
    }

    public Integer getIdcart() {
        return idcart;
    }

    public void setIdcart(Integer idcart) {
        this.idcart = idcart;
    }

    public Collection<CartDetail> getCartDetailCollection() {
        return cartDetailCollection;
    }

    public void setCartDetailCollection(Collection<CartDetail> cartDetailCollection) {
        this.cartDetailCollection = cartDetailCollection;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcart != null ? idcart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.idcart == null && other.idcart != null) || (this.idcart != null && !this.idcart.equals(other.idcart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.librarymanagement.entity.Cart[ idcart=" + idcart + " ]";
    }
    
}
