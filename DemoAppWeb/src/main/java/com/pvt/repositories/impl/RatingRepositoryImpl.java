/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.repositories.impl;

import com.pvt.pojo.Rating;
import com.pvt.pojo.Rating;
import com.pvt.repositories.RatingRepository;
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
public class RatingRepositoryImpl implements RatingRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Override
    public List<Rating> getRatings(Map<String, String> params) {
         Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Rating> q = b.createQuery(Rating.class);
        Root root = q.from(Rating.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
//        String fromLoc = params.get("fromLoc");
//        String toLoc = params.get("toLoc");
        String kwScore = params.get("kwScore");
        if (kwScore!= null && !kwScore.isEmpty()) {
            predicates.add(b.like(root.get("score"), String.format("%%%s%%", kwScore)));
        }
        String kwComment = params.get("kwComment");
        if (kwComment != null && !kwComment.isEmpty()) {
            predicates.add(b.like(root.get("comment"), String.format("%%%s%%", kwComment)));
        }
        
        q.where(predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);

        List<Rating> ratings = query.getResultList();
        return ratings;
    }

 
    public void addOrUpdate(Rating rate) {
        Session s = this.factory.getObject().getCurrentSession();
        s.saveOrUpdate(rate);
    }

    @Override
    public Rating getRatingById(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        return s.get(Rating.class, id);
    }

    @Override
    public void deleteRating(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        Rating j = this.getRatingById(id);
        s.delete(j);
    }
    
}
