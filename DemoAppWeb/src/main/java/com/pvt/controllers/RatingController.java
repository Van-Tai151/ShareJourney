/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.Rating;
import com.pvt.services.RatingService;
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
public class RatingController {
    @Autowired
    private RatingService rateService;

    @GetMapping("/ratings")
    public String addRatingView(Model model) {
        model.addAttribute("rating", new Rating());
        return "ratings";
    }
    @GetMapping("/ratings/{ratingId}")
    public String updateProductView(Model model, @PathVariable(value = "ratingId") int id) {
        model.addAttribute("rating", this.rateService.getRatingById(id));
        
        return "ratings";
    }

    @PostMapping("/ratings")
    public String creatRating(Model model, @ModelAttribute(value = "rating") @Valid Rating j, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.rateService.addOrUpdate(j);

                return "redirect:/";
            } catch (Exception ex) {
                model.addAttribute("errMsg", ex.toString());
            }
        }
        return "ratings";
    }
}
