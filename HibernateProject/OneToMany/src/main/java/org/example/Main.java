package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book();
        b1.setBookName("A good girl's guide to murder");

        Book b2 = new Book();
        b2.setBookName("Good girl, bad blood");

        Book b3 = new Book();
        b3.setBookName("As good as dead");

        Author author = new Author();
        author.setAuthName("Holly Jackson");
        author.setBooks(Arrays.asList(b1,b2,b3));

        b1.setAuthor(author);
        b2.setAuthor(author);
        b3.setAuthor(author);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(b1);
        session.persist(b2);
        session.persist(b3);
        session.persist(author);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}