/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories;

import com.pvt.pojo.User;

/**
 *
 * @author Tài đẹp trai
 */
public interface UserRepository {
    User getUserByUserName(String username);
    void addUser(User user);  
}
