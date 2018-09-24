package com.example.daniellee.food_trucks_buildings;

import java.io.Serializable;

// store data for one truck
public class Truck implements Serializable{
    private String name;
    private double rating;
    private String streets;
    private String type;
    private double[] coordinates;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStreets() {
        return streets;
    }

    public void setStreets(String streets) {
        this.streets = streets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Truck (String n, double r, String s, String t, double [] c, String p) {
        name = n;
        rating = r;
        streets = s;
        type = t;
        coordinates = c;
        phone = p;
    }
}
