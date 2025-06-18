
package com.example.model;

public class Employee {
    private int id;
    private String name;
    private String branch;
    private String email;
    private String number;
    
    public Employee(){}

    public Employee(int id, String name, String branch, String email, String number) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.email = email;
        this.number = number;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
