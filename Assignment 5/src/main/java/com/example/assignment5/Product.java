package com.example.assignment5;

public class Product {
    private int id;
    private String name;
    private String company;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }
}