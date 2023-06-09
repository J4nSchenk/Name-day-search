package com.example.names.Entity;


import javax.persistence.*;


@Entity
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String date;

    private Integer count;

    @ManyToOne
    private Nameday nameday;

//constructor
public Name() {
    // Empty constructor
}

    public Name(Long id, String name, String date, Integer count, Nameday nameday) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.count = count;
        this.nameday = nameday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Nameday getNameday() {
        return nameday;
    }

    public void setNameday(Nameday nameday) {
        this.nameday = nameday;
    }
}
