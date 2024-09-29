/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.services.CategoryService;
import com.pvt.services.JourneyService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tài đẹp trai
 */
@Controller
@ControllerAdvice
public class HomeController {
    
    @Autowired
    private CategoryService cateService;
    @Autowired
    private JourneyService jourService;
   
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.cateService.getCates());
    }
    
    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {       
        model.addAttribute("journeys", this.jourService.getJourneys(params));        
        return "index";
    }
 
}
