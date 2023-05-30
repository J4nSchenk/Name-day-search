package com.example.names;



public class Names {
    private String id;

    private String name;

    private String date;

    private int count;


//constructor
    public Names(String id, String name, String date, int count) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.count = count;
    }

    // Gettery a Settery

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
