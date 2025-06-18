
package com.example.model;

import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private String customer;
    private String car;
    private String employee;
    private double discount;
    
    public Order(){}

    public Order(int id, Date date, String customer, String car, String employee, double discount) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.car = car;
        this.employee = employee;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
}
