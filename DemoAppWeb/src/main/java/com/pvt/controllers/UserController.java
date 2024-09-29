/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

/**
 *
 * @author Tài đẹp trai
 */

import com.pvt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserController {
    @GetMapping("/users")
    public String creatUser(Model model){
        model.addAttribute("user",new User());
        return "users";
    }
}
