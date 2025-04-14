package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Address add = new Address();
        add.setAddName("ABC");
        add.setStreet("St123");
        add.setCity("MyCity");
        add.setState("MyState");
        add.setPincode(123456);

        Employee emp = new Employee();
        emp.setFirstName("Nidhi");
        emp.setLastName("Rajvir");
        emp.setMobNo(1234567890);
        emp.setAdd(add);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Employee.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        session.persist(emp);

        transaction.commit();
        session.close();

        Session session2 = sf.openSession();
        Employee employee = session2.get(Employee.class,1);
        System.out.println(employee);

        sf.close();
    }
}