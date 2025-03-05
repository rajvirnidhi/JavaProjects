package org.example;

import jakarta.persistence.Entity; // standard structure for all the ORM tools to follow
import jakarta.persistence.Id;

@Entity // need to mention the entity annotation so hibernate will recognize that it is a class which needs to be represented in db
public class Student {

    @Id // specifying primary key for the table
    private int rollno;
    private String name;
    private int age;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
