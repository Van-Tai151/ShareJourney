/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.controllers;

import com.pvt.pojo.Journey;
import com.pvt.services.JourneyService;
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
public class ApiJourneyController {
    @Autowired
    private JourneyService journeyService;
    
    @GetMapping("/journeys/")
    public ResponseEntity<List<Journey>> list(@RequestParam  Map params) {
        return new ResponseEntity<>(this.journeyService.getJourneys(params),HttpStatus.OK);
    }
    @GetMapping(path = "/journeys/{journeyId}/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Journey> retrieve(@PathVariable(value = "journeyId") int id) {
        return new ResponseEntity<>(this.journeyService.getJourneyById(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/journeys/{journeyId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable(value = "journeyId") int id) {
        this.journeyService.deleteJourney(id);
    }
}
