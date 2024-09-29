/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories.impl;

import com.pvt.pojo.Report;
import com.pvt.repositories.ReportRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tài đẹp trai
 */
@Repository
@Transactional

public class ReportRepositoryImpl implements ReportRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    
    @Override
    public List<Report> getRepots(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Report> q = b.createQuery(Report.class);
        Root root = q.from(Report.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
//        String fromLoc = params.get("fromLoc");
//        String toLoc = params.get("toLoc");
        String kwId = params.get("kwId");
        if (kwId!= null && !kwId.isEmpty()) {
            predicates.add(b.like(root.get("id"), String.format("%%%s%%", kwId)));
        }
        String kwReason = params.get("kwReason");
        if (kwReason != null && !kwReason.isEmpty()) {
            predicates.add(b.like(root.get("reason"), String.format("%%%s%%", kwReason)));
        }
        q.where(predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);     
        List<Report> reports = query.getResultList();
        return reports;
    }

    @Override
    public Report getReportById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Report.class, id);
    }

}
