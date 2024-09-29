/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories;

import com.pvt.pojo.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tài đẹp trai
 */
public interface RatingRepository {
     List<Rating> getRatings(Map<String, String> params);

    void addOrUpdate(Rating rate);

    Rating getRatingById(int id);

    void deleteRating(int id);
}
