/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services.impl;

import com.pvt.pojo.Report;
import com.pvt.repositories.ReportRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pvt.services.ReportService;

/**
 *
 * @author Tài đẹp trai
 */
@Service

public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reRepository;

    @Override
    public List<Report> getRepots(Map<String, String> params) {
        return this.reRepository.getRepots(params);
    }

    @Override
    public Report getReportById(int id) {
        return this.reRepository.getReportById(id);

    }

}
