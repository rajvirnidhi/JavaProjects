package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setLaptop_id(1);
        laptop.setBrand("HP");
        laptop.setModel("HP-27F3K");
        laptop.setRam(16);

        Laptop laptop2 = new Laptop();
        laptop2.setLaptop_id(2);
        laptop2.setBrand("Dell");
        laptop2.setModel("XPS");
        laptop2.setRam(32);

        MyUser user = new MyUser();
        user.setUserId(1);
        user.setUserName("Nidhi");
        user.setTech("Java");
        user.setLaptops(Arrays.asList(laptop,laptop2));

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.MyUser.class);
        cfg.addAnnotatedClass(org.example.Laptop.class);
        cfg.configure();
        SessionFactory sf= cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(user);
        transaction.commit();

        MyUser myuser = session.get(MyUser.class, 1);
        System.out.println(myuser);
        session.close();
        sf.close();
    }
}