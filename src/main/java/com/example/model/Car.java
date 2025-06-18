
package com.example.model;

public class Car {
    private int id;
    private String name;
    private String brand;
    private int year;
    private int category_id;
    private int branch_id;
    
    public Car(){}

    public Car(int id, String name, String brand, int year, int category_id, int branch_id) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.category_id = category_id;
        this.branch_id = branch_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
    
    
  

    
   
}
