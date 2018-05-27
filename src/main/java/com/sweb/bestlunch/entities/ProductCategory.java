package com.sweb.bestlunch.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public ProductCategory(String name){
        this.name = name;
    }
}

