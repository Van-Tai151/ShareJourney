/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.demo;

import com.pvt.pojo.Category;
import com.pvt.pojo.Comment;
import com.pvt.pojo.Journey;
import com.pvt.pojo.Photo;
import com.pvt.pojo.Rating;
import com.pvt.pojo.Report;
import com.pvt.pojo.Thamgiachuyendi;
import com.pvt.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Tài đẹp trai
 */
public class HibernateUtils {

    private static final SessionFactory factory;

    static {
        Configuration conf = new Configuration();
//        conf.configure("hibernate.cfg.xml");
        Properties props = new Properties();
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/db");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "tai@123456");
        props.put(Environment.SHOW_SQL, "true");
        conf.setProperties(props);

        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Journey.class);
        conf.addAnnotatedClass(Rating.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(Photo.class);
        conf.addAnnotatedClass(Report.class);
        conf.addAnnotatedClass(Thamgiachuyendi.class);
        conf.addAnnotatedClass(Category.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        factory = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return factory;

    }
}
