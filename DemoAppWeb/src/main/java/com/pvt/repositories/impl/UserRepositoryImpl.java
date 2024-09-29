/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories.impl;

import com.pvt.pojo.User;
import com.pvt.repositories.UserRepository;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tài đẹp trai
 */
@Repository //tao hat dau lien ket db
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public User getUserByUserName(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");//user nay la lop 
        q.setParameter("username", username);
        return (User) q.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);
    }
}
