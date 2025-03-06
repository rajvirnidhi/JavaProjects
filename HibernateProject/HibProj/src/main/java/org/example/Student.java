package org.example;

import jakarta.persistence.*;

// there are 3 things here,
// Table name, Entity name and Class name
// from the class name the entity name is set and from entity name table name is set
//@Entity (name = "student_name") //--> sets entity and table name as student_name
@Entity // need to mention the entity annotation so hibernate will recognize that it is a class which needs to be represented in db
//@Table(name = "student_table")
public class Student {

    @Id // specifying primary key for the table
    private int rollno;
    //@Column(name = "student_name") // this will change the column name as student_name
    private String name;
    //@Transient // prevent this column from being added to the table
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
