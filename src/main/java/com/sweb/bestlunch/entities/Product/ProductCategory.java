package com.sweb.bestlunch.entities.Product;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
