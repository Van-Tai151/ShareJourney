/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tài đẹp trai
 */
@Entity
@Table(name = "thamgiachuyendi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thamgiachuyendi.findAll", query = "SELECT t FROM Thamgiachuyendi t"),
    @NamedQuery(name = "Thamgiachuyendi.findById", query = "SELECT t FROM Thamgiachuyendi t WHERE t.id = :id"),
    @NamedQuery(name = "Thamgiachuyendi.findByName", query = "SELECT t FROM Thamgiachuyendi t WHERE t.name = :name")})
public class Thamgiachuyendi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "journey_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Journey journeyId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Thamgiachuyendi() {
    }

    public Thamgiachuyendi(Integer id) {
        this.id = id;
    }

    public Thamgiachuyendi(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Journey getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Journey journeyId) {
        this.journeyId = journeyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Thamgiachuyendi)) {
            return false;
        }
        Thamgiachuyendi other = (Thamgiachuyendi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pvt.pojo.Thamgiachuyendi[ id=" + id + " ]";
    }
    
}
