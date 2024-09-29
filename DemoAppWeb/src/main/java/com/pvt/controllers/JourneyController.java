/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.Journey;
import com.pvt.services.JourneyService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tài đẹp trai
 */
@Controller
public class JourneyController {

    @Autowired
    private JourneyService jourService;

    @GetMapping("/journeys")
    public String addJourneyView(Model model) {
        model.addAttribute("journey", new Journey());
        return "journeys";
    }
    @GetMapping("/journeys/{journeyId}")
    public String updateProductView(Model model, @PathVariable(value = "journeyId") int id) {
        model.addAttribute("journey", this.jourService.getJourneyById(id));
        
        return "journeys";
    }

    @PostMapping("/journeys")
    public String creatJourney(Model model, @ModelAttribute(value = "journey") @Valid Journey j, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.jourService.addOrUpdate(j);

                return "redirect:/";
            } catch (Exception ex) {
                model.addAttribute("errMsg", ex.toString());
            }
        }
        return "journeys";
    }
}
