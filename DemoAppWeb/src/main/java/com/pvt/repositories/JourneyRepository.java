/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories;

import com.pvt.pojo.Journey;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tài đẹp trai
 */
public interface JourneyRepository {

    List<Journey> getJourneys(Map<String, String> params);

    void addOrUpdate(Journey j);

    Journey getJourneyById(int id);

    void deleteJourney(int id);
}
