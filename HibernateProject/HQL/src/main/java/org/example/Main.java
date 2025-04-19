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
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        // need to change the type of list as we are fetching 2 columns now
        List<Object[]> laptops = query.getResultList();

        // getting one row of object array and displaying the values
        for (Object[] data : laptops)
        {   // data[0] is by default object type, so you need to typecast it
            System.out.println((String)data[0]+ " " +(String)data[1]);
        }

        session.close();
        sf.close();
    }
}