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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fromLocation")
    private String fromLocation;
    @Basic(optional = false)
    @Column(name = "toLocation")
    private String toLocation;
    @Basic(optional = false)
    @Column(name = "estimatedTime")
    private String estimatedTime;
    @Column(name = "isActive")
    private Short isActive;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Rating> ratingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Photo> photoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journeyId")
    private Set<Thamgiachuyendi> thamgiachuyendiSet;

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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Photo> getPhotoSet() {
        return photoSet;
    }

    public void setPhotoSet(Set<Photo> photoSet) {
        this.photoSet = photoSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @XmlTransient
    public Set<Thamgiachuyendi> getThamgiachuyendiSet() {
        return thamgiachuyendiSet;
    }

    public void setThamgiachuyendiSet(Set<Thamgiachuyendi> thamgiachuyendiSet) {
        this.thamgiachuyendiSet = thamgiachuyendiSet;
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
    
}
