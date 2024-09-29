/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories.impl;

import com.pvt.pojo.Journey;
import com.pvt.repositories.JourneyRepository;
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
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tài đẹp trai
 */
@Repository
@Transactional
public class JourneyRepositoryImpl implements JourneyRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Journey> getJourneys(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Journey> q = b.createQuery(Journey.class);
        Root root = q.from(Journey.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
//        String fromLoc = params.get("fromLoc");
//        String toLoc = params.get("toLoc");
        String kwFromLocation = params.get("kwFromLocation");
        if (kwFromLocation != null && !kwFromLocation.isEmpty()) {
            predicates.add(b.like(root.get("fromLocation"), String.format("%%%s%%", kwFromLocation)));
        }
        String kwToLocation = params.get("kwToLocation");
        if (kwToLocation != null && !kwToLocation.isEmpty()) {
            predicates.add(b.like(root.get("toLocation"), String.format("%%%s%%", kwToLocation)));
        }
        String cateId = params.get("cateId");
        if (cateId != null && !cateId.isEmpty()) {
            predicates.add(b.equal(root.get("categoryId"), (Integer) Integer.parseInt(cateId)));
        }
        q.where(predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);
        String p = params.get("page");
        if (p != null && !p.isEmpty()) {
            int pageSize = Integer.parseInt(env.getProperty("journeys.pageSize").toString());
            int start = (Integer.parseInt(p) - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);
        }

        List<Journey> journeys = query.getResultList();
        return journeys;
    }

    public void addOrUpdate(Journey j) {
        Session s = this.factory.getObject().getCurrentSession();
        s.saveOrUpdate(j);
    }

    @Override
    public Journey getJourneyById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Journey.class, id);
    }

    @Override
    public void deleteJourney(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Journey j = this.getJourneyById(id);
        s.delete(j);
    }

}
