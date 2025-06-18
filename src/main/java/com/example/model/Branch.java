
package com.example.model;

public class Branch {
    private int id;
    private String name;
    private String address;
    private String number;
    private int manager_id;
    
    public Branch(){}

    public Branch(int id, String name, String address, String number, int manager_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.manager_id = manager_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    
    
    
}
