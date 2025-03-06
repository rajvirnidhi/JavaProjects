package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setBrand("HP");
        laptop.setModel("HP-27F3K");
        laptop.setRam(16);

        MyUser user = new MyUser();
        user.setUserId(1);
        user.setUserName("Nidhi");
        user.setTech("Java");
        user.setLaptop(laptop);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.MyUser.class);
        cfg.configure();
        SessionFactory sf= cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();

        MyUser myuser = session.get(MyUser.class, 1);
        System.out.println(myuser);
        session.close();
        sf.close();
    }
}