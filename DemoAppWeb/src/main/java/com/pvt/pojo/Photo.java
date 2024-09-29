/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tài đẹp trai
 */
@Entity
@Table(name = "photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p"),
    @NamedQuery(name = "Photo.findById", query = "SELECT p FROM Photo p WHERE p.id = :id"),
    @NamedQuery(name = "Photo.findByName", query = "SELECT p FROM Photo p WHERE p.name = :name"),
    @NamedQuery(name = "Photo.findByPhotoURL", query = "SELECT p FROM Photo p WHERE p.photoURL = :photoURL"),
    @NamedQuery(name = "Photo.findByPhotocol", query = "SELECT p FROM Photo p WHERE p.photocol = :photocol")})
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photoURL")
    private String photoURL;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "photocol")
    private String photocol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photoId")
    private Set<ProdPhoto> prodPhotoSet;

    public Photo() {
    }

    public Photo(Integer id) {
        this.id = id;
    }

    public Photo(Integer id, String name, String photoURL) {
        this.id = id;
        this.name = name;
        this.photoURL = photoURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotocol() {
        return photocol;
    }

    public void setPhotocol(String photocol) {
        this.photocol = photocol;
    }

    @XmlTransient
    public Set<ProdPhoto> getProdPhotoSet() {
        return prodPhotoSet;
    }

    public void setProdPhotoSet(Set<ProdPhoto> prodPhotoSet) {
        this.prodPhotoSet = prodPhotoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pvt.pojo.Photo[ id=" + id + " ]";
    }
    
}
