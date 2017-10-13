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
@Table(name = "storage")
@NamedQueries({
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s")})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStorage")
    private Integer idStorage;
    @Size(max = 255)
    @Column(name = "nameStoragel")
    private String nameStoragel;
    @OneToMany(mappedBy = "idStorage")
    private Collection<Book> bookCollection;

    public Storage() {
    }

    public Storage(Integer idStorage) {
        this.idStorage = idStorage;
    }

    public Integer getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(Integer idStorage) {
        this.idStorage = idStorage;
    }

    public String getNameStoragel() {
        return nameStoragel;
    }

    public void setNameStoragel(String nameStoragel) {
        this.nameStoragel = nameStoragel;
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
        hash += (idStorage != null ? idStorage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.idStorage == null && other.idStorage != null) || (this.idStorage != null && !this.idStorage.equals(other.idStorage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.librarymanagement.entity.Storage[ idStorage=" + idStorage + " ]";
    }
    
}
