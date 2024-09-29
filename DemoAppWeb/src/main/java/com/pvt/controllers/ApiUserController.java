/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.User;
import com.pvt.services.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private UserService userService;
    
    @PostMapping(path = "/users/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE //upload file
    })
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam Map<String, String> params) {
        User user = new User();
        user.setId(12);
        user.setUsername(params.get("username"));
        user.setAvatar(params.get("avatar"));
        user.setPassword(params.get("password"));
        user.setRole(params.get("role"));
        this.userService.addUser(user);
    }
}
