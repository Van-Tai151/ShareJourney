/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.Category;
import com.pvt.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tài đẹp trai
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCategoryController {
    @Autowired
    private CategoryService cateService;
    @GetMapping("/categories/")
    public ResponseEntity<List<Category>> list(){
         return new ResponseEntity<>(this.cateService.getCates(), HttpStatus.OK);
    }
}
