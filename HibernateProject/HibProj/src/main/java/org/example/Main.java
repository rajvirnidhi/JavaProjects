package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setRollno(26);
        s.setName("Purva");
        s.setAge(28);

        // 2 ways
        // 1. using xml --> all the resources and xml files go to resources folder
        // 2. using annotations
//        Configuration cfg = new Configuration(); // --> it know it has to find configuration somewhere
//        cfg.addAnnotatedClass(org.example.Student.class); // --> we need to map the class
//        cfg.configure(); // --> this loads the xml for xml you can use default name or can specify the name here

        // session factory has method open session to return session object
        // session factory is also an interface
        // so buildSessionFactory in configuration gives object of SessionFactory
        //SessionFactory is heavy-weight object so use it only once
//        SessionFactory sf = cfg.buildSessionFactory();


        //reduce 3 lines of cfg to one
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        // session is an interface and not class, so we cannot create an object of it
        //NOTE: for any unit of work we will create new session
        Session session = sf.openSession();

        // while fetching the data we don't need transaction or persist
//        Transaction transaction = session.beginTransaction();
//        session.persist(s);

        // save is deprecated
        //session.save(s); // this is transaction, so we need to commit this transaction
//        transaction.commit();


        Student s2= null;
        // We can use get method to get some value stored in db using primary key
        // automatically hibernate will convert the values to properties in object
        s2=session.get(Student.class,25);
        //note you can use s2!=null before using object
        System.out.println(s2);
        //good practice to close it
        session.close();
        sf.close();
    }
}