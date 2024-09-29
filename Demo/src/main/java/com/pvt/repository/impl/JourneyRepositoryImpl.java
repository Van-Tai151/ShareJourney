/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repository.impl;

import java.util.List;
import com.pvt.pojo.Journey;
import com.pvt.demo.HibernateUtils;
import java.util.ArrayList;
/**
 *
 * @author Tài đẹp trai
 */
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class JourneyRepositoryImpl {

    public List<Journey> getJourneys(Map<String, String> params) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Journey> q = b.createQuery(Journey.class);
            Root root = q.from(Journey.class);
            q.select(root);

            List<Predicate> predicates = new ArrayList<>();
            String fromLoc = params.get("fromLoc");
            String toLoc = params.get("toLoc");
            if (fromLoc != null && !fromLoc.isEmpty())
                predicates.add(b.like(root.get("fromLocation"), String.format("%%%s%%", fromLoc)));
            else if (toLoc != null && !toLoc.isEmpty())
                predicates.add(b.like(root.get("toLocation"), String.format("%%%s%%", toLoc)));         
            q.where(predicates.toArray(Predicate[]::new));

            q.orderBy(b.desc(root.get("id")));
            Query query = session.createQuery(q);
            List<Journey> journeys = query.getResultList();
            return journeys;
        
        }   
    }
    public Journey getJourneyById(int id ){
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.get(Journey.class, id);
        }
    }
    public void addorUpdateJourney(Journey p){
        try (Session session = HibernateUtils.getFactory().openSession()) {
            session.persist(p);
        }
    }
}
