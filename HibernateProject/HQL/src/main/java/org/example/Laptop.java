package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop
{
    @Id
    private int laptop_id;
    private String brand;
    private String model;
    private int ram;

    public int getId() {
        return laptop_id;
    }

    public void setId(int id) {
        this.laptop_id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + laptop_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
