package org.example;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "author_table")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authID;
    @Column(name = "author_name")
    private String authName;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    //@Column(name = "books")--> cannot use this as books won't be stored as column
    private List<Book> books;

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authID=" + authID +
                ", authName='" + authName + '\'' +
                ", books=" + books +
                '}';
    }
}
