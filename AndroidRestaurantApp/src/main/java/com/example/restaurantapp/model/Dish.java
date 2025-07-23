package com.example.restaurantapp.model;

public class Dish {
    private int id;
    private String name;
    private String type; // appetizer, main course, dessert
    private double price;
    private String description;
    private int imageResourceId;

    public Dish(int id, String name, String type, double price, String description, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.imageResourceId = imageResourceId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
