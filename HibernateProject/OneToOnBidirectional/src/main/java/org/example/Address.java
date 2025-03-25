package org.example;

import jakarta.persistence.*;

@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addID;
    private String addName;
    private String street;
    private String city;
    private String state;
    private int pincode;
    @OneToOne(mappedBy = "add",
            cascade = CascadeType.ALL)
    private Employee employee;

    public int getAddID() {
        return addID;
    }

    public void setAddID(int addID) {
        this.addID = addID;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addID=" + addID +
                ", addName='" + addName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                ", employeeID=" + (employee != null ? employee.getEmpID() : "No Employee") +  // Avoid recursion
                '}';
    }
}
