/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.pojo.Report;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tài đẹp trai
 */
public interface ReportService {

    List<Report> getRepots(Map<String, String> params);

    Report getReportById(int id);

}
