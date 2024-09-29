/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Tài đẹp trai
 */
@Entity
@Table(name = "journey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Journey.findAll", query = "SELECT j FROM Journey j"),
    @NamedQuery(name = "Journey.findById", query = "SELECT j FROM Journey j WHERE j.id = :id"),
    @NamedQuery(name = "Journey.findByFromLocation", query = "SELECT j FROM Journey j WHERE j.fromLocation = :fromLocation"),
    @NamedQuery(name = "Journey.findByToLocation", query = "SELECT j FROM Journey j WHERE j.toLocation = :toLocation"),
    @NamedQuery(name = "Journey.findByEstimatedTime", query = "SELECT j FROM Journey j WHERE j.estimatedTime = :estimatedTime"),
    @NamedQuery(name = "Journey.findByIsActive", query = "SELECT j FROM Journey j WHERE j.isActive = :isActive")})
public class Journey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{journey.name.nullErr}")
    @Size(min = 1, max = 255)
    @Column(name = "fromLocation")
    private String fromLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "toLocation")
    private String toLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estimatedTime")
    private String estimatedTime;
    @JsonIgnore

    @Column(name = "isActive")
    private Short isActive;
    @JsonIgnore
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Rating> ratingSet;
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Comment> commentSet;
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<ProdPhoto> prodPhotoSet;
    @Transient
    private MultipartFile file;

    public Journey() {
    }

    public Journey(Integer id) {
        this.id = id;
    }

    public Journey(Integer id, String fromLocation, String toLocation, String estimatedTime) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.estimatedTime = estimatedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof Journey)) {
            return false;
        }
        Journey other = (Journey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pvt.pojo.Journey[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
