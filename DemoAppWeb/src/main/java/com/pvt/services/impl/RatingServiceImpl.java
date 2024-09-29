/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services.impl;

import com.pvt.pojo.Rating;
import com.pvt.repositories.RatingRepository;
import com.pvt.services.RatingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tài đẹp trai
 */
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository rateRepository;
    @Override
    public List<Rating> getRatings(Map<String, String> params) {
        return this.rateRepository.getRatings(params);
    }

    @Override
    public void addOrUpdate(Rating rate) {
                this.rateRepository.addOrUpdate(rate);
    }

    @Override
    public Rating getRatingById(int id) {
        return this.rateRepository.getRatingById(id);
    }

    @Override
    public void deleteRating(int id) {
                this.rateRepository.deleteRating(id);

    }
    
}
