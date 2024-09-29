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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Journey> journeySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Rating> ratingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportedUserId")
    private Set<Report> reportSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Photo> photoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Thamgiachuyendi> thamgiachuyendiSet;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Set<Journey> getJourneySet() {
        return journeySet;
    }

    public void setJourneySet(Set<Journey> journeySet) {
        this.journeySet = journeySet;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Report> getReportSet() {
        return reportSet;
    }

    public void setReportSet(Set<Report> reportSet) {
        this.reportSet = reportSet;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pvt.pojo.User[ id=" + id + " ]";
    }
    
}
