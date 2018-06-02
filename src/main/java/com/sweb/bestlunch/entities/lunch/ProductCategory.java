package com.sweb.bestlunch.entities.lunch;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name="product_categories")
public class ProductCategory {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}

