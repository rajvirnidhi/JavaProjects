package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        //SQL --> select * from laptop where ram=32
        //HQL --> from Laptop where ram=32
        //HQL Laptop is class

        //from Laptop where brand like 'HP'  --> here remember to give single quotes while passing hardcoded value

        String brand = "HP";
        Query query = session.createQuery("from Laptop where brand like ?1");
        query.setParameter(1,brand);
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}