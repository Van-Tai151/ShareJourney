/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services.impl;

import com.pvt.pojo.User;
import com.pvt.repositories.UserRepository;
import com.pvt.services.UserService;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tài đẹp trai
 */
@Service("userDetailsService") // cung hat dau nhung no lay ten cua minh
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository useRepository;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUserName(String username) {
        return this.useRepository.getUserByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.useRepository.getUserByUserName(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid username!");
        }
        Set<GrantedAuthority> a = new HashSet<>();
        a.add(new SimpleGrantedAuthority(u.getRole()));
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), a);
    }

//    @Override
//    public void addUser(User user) {
//        user.setPassword(passEncoder.encode(user.getPassword()).toString());
//        if (!user.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                user.setAvatar(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        this.us.addUser(user);
//    
//    }

    @Override
    public void addUser(User user) {
        this.useRepository.addUser(user);
    }

}
