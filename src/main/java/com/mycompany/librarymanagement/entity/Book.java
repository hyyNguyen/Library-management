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
import javax.validation.constraints.Size;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBook")
    private Integer idBook;
    @Size(max = 255)
    @Column(name = "nameBook")
    private String nameBook;
    @Size(max = 255)
    @Column(name = "imageBook")
    private String imageBook;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 255)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 1000)
    @Column(name = "description1")
    private String description1;
    @Size(max = 1000)
    @Column(name = "description2")
    private String description2;
    @Size(max = 1000)
    @Column(name = "description3")
    private String description3;
    @Size(max = 1000)
    @Column(name = "description4")
    private String description4;
    @OneToMany(mappedBy = "idBook")
    private Collection<CartDetail> cartDetailCollection;
    @JoinColumn(name = "idPublishing_company", referencedColumnName = "idPublishing_company")
    @ManyToOne
    private PublishingCompany idPublishingcompany;
    @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor")
    @ManyToOne
    private Author idAuthor;
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    @ManyToOne
    private Category idCategory;
    @JoinColumn(name = "idStorage", referencedColumnName = "idStorage")
    @ManyToOne
    private Storage idStorage;

    public Book() {
    }

    public Book(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getImageBook() {
        return imageBook;
    }

    public void setImageBook(String imageBook) {
        this.imageBook = imageBook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public Collection<CartDetail> getCartDetailCollection() {
        return cartDetailCollection;
    }

    public void setCartDetailCollection(Collection<CartDetail> cartDetailCollection) {
        this.cartDetailCollection = cartDetailCollection;
    }

    public PublishingCompany getIdPublishingcompany() {
        return idPublishingcompany;
    }

    public void setIdPublishingcompany(PublishingCompany idPublishingcompany) {
        this.idPublishingcompany = idPublishingcompany;
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Storage getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(Storage idStorage) {
        this.idStorage = idStorage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBook != null ? idBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.idBook == null && other.idBook != null) || (this.idBook != null && !this.idBook.equals(other.idBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.librarymanagement.entity.Book[ idBook=" + idBook + " ]";
    }
    
}
