/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pvt.demo;

import com.pvt.pojo.User;
import com.pvt.repository.impl.JourneyRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import javax.persistence.Query;
/**
 *
 * @author Tài đẹp trai
 */
public class Demo {

    public static void main(String[] args) {
        JourneyRepositoryImpl s = new JourneyRepositoryImpl();
        Map<String , String> params = new HashMap<>();
        params.put("fromLoc","TPHCM");
        s.getJourneys(params).forEach(p->System.out.println(p.getId()+ " - "+p.getFromLocation()+" - "+p.getToLocation()));
//        try ( Session s = HibernateUtils.getFactory().openSession()){
//            Query u = s.createQuery("FROM User");
//            List<User> cates = u.getResultList();
//            cates.forEach(c -> System.err.println(c.getUsername()));
//        }
//    }
}
}
