 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Tài đẹp trai
 */
public interface UserService extends UserDetailsService{ //ke thua cai gi do de bien cua ngta thanh cua minh
    User getUserByUserName(String username);
     void addUser(User user);
}
