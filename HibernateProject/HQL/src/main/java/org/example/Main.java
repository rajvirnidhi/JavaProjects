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
        Query query = session.createQuery("select model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        // need to change the type of list as we are fetching model only
        List<String> laptop_model = query.getResultList();

        System.out.println(laptop_model);

        session.close();
        sf.close();
    }
}