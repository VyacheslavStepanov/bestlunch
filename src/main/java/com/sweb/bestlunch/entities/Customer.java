package com.sweb.bestlunch.entities;

import javax.naming.Name;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
