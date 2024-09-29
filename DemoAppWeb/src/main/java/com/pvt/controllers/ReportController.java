/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;
import com.pvt.pojo.Report;
import com.pvt.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Tài đẹp trai
 */
@Controller
public class ReportController {
    @Autowired
    private ReportService reService;
    
    @GetMapping("/reports")
    public String addJourneyView(Model model) {
        model.addAttribute("report", new Report());
        return "reports";
    }
}
