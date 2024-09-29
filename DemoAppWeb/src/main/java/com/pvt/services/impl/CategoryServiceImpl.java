/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services.impl;

import com.pvt.pojo.Category;
import com.pvt.repositories.CategoryRepository;
import com.pvt.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tài đẹp trai
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository cateRepository;
    @Override
    public List<Category> getCates() {
        return this.cateRepository.getCates();
    }
    
}
