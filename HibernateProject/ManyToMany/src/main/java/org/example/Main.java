package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Course course1 = new Course();
        course1.setC_name("Java");

        Course course2 = new Course();
        course2.setC_name("Hibernate");

        Course course3 = new Course();
        course3.setC_name("Spring");

        Student st1 = new Student();
        st1.setName("Nidhi");
        st1.setCourses(Arrays.asList(course2,course3));

        Student st2 = new Student();
        st2.setName("Purva");
        st2.setCourses(Arrays.asList(course1));

        Student st3 = new Student();
        st3.setName("Nisha");
        st3.setCourses(Arrays.asList(course1,course2,course3));

        course1.setStudents(Arrays.asList(st2,st3));
        course2.setStudents(Arrays.asList(st1,st3));
        course3.setStudents(Arrays.asList(st1,st3));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(course1);
        session.persist(course2);
        session.persist(course3);
        session.persist(st1);
        session.persist(st2);
        session.persist(st3);


        transaction.commit();
        Student getStu =session.get(Student.class, 1);
        System.out.println(getStu);
        session.close();
        sessionFactory.close();


    }
}