/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services.impl;

import com.pvt.pojo.Journey;
import com.pvt.repositories.JourneyRepository;
import com.pvt.services.JourneyService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tài đẹp trai
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository jourRepository;

    @Override
    public List<Journey> getJourneys(Map<String, String> params) {
        return this.jourRepository.getJourneys(params);
    }

    @Override
    public void addOrUpdate(Journey j) {
        this.jourRepository.addOrUpdate(j);
    }

    @Override
    public Journey getJourneyById(int id) {

        return this.jourRepository.getJourneyById(id);
    }

    @Override
    public void deleteJourney(int id) {
        this.jourRepository.deleteJourney(id);

    }

}
