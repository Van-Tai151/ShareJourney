/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.Rating;
import com.pvt.services.RatingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tài đẹp trai
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiRatingController {
    @Autowired
    private RatingService ratingService;
    
    @GetMapping("/ratings/")
    public ResponseEntity<List<Rating>> list(@RequestParam  Map params) {
        return new ResponseEntity<>(this.ratingService.getRatings(params),
                HttpStatus.OK);
    }
    @GetMapping(path = "/ratings/{ratingId}/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Rating> retrieve(@PathVariable(value = "ratingId") int id) {
        return new ResponseEntity<>(this.ratingService.getRatingById(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/ratings/{ratingId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable(value = "ratingId") int id) {
        this.ratingService.deleteRating(id);
    }
}
