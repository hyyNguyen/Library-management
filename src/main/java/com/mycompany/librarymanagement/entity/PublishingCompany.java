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
@Table(name = "publishing_company")
@NamedQueries({
    @NamedQuery(name = "PublishingCompany.findAll", query = "SELECT p FROM PublishingCompany p")})
public class PublishingCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPublishing_company")
    private Integer idPublishingcompany;
    @Size(max = 255)
    @Column(name = "namePublishing_company")
    private String namePublishingcompany;
    @OneToMany(mappedBy = "idPublishingcompany")
    private Collection<Book> bookCollection;

    public PublishingCompany() {
    }

    public PublishingCompany(Integer idPublishingcompany) {
        this.idPublishingcompany = idPublishingcompany;
    }

    public Integer getIdPublishingcompany() {
        return idPublishingcompany;
    }

    public void setIdPublishingcompany(Integer idPublishingcompany) {
        this.idPublishingcompany = idPublishingcompany;
    }

    public String getNamePublishingcompany() {
        return namePublishingcompany;
    }

    public void setNamePublishingcompany(String namePublishingcompany) {
        this.namePublishingcompany = namePublishingcompany;
    }

    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublishingcompany != null ? idPublishingcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublishingCompany)) {
            return false;
        }
        PublishingCompany other = (PublishingCompany) object;
        if ((this.idPublishingcompany == null && other.idPublishingcompany != null) || (this.idPublishingcompany != null && !this.idPublishingcompany.equals(other.idPublishingcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.librarymanagement.entity.PublishingCompany[ idPublishingcompany=" + idPublishingcompany + " ]";
    }
    
}
