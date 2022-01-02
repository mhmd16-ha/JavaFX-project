package com.example.demo1;

public class Student {
    private int id;
    private String name;
    private Double gpa;
    private String dpt;
    private String address;

    public Student(int id, String name, Double gpa, String dpt, String address) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.dpt = dpt;
        this.address = address;
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

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

}
