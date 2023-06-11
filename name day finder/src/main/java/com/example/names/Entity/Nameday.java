package com.example.names.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Nameday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY strategy for auto-generation
    private Long id;

    private String date;
    private String name;
    private int count;

    public Nameday() {
    }

    public Nameday(String date, String name) {
        this.date = date;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonIgnore
    public int getRequestCount() {
        return count;
    }

    public void setRequestCount(int count) {
        this.count = count;
    }


    @JsonIgnore
    public String getNameday() {
        return date;
    }

    @JsonIgnore
    public void setNameday(String nameday) {
        this.date = nameday;
    }

}

