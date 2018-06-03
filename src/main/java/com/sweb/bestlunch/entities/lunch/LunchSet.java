package com.sweb.bestlunch.entities.lunch;

import com.sweb.bestlunch.entities.product.Product;
import com.sweb.bestlunch.entities.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LunchSet {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="lunchset_searchtag",
        joinColumns=@JoinColumn(name="lunchset_id"),
        inverseJoinColumns =@JoinColumn(name="searchtag_id")
    )
    private List<SearchTag> tags = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="lunchset_product",
        joinColumns=@JoinColumn(name="lunchset_id"),
        inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products = new ArrayList<>();
    private String description;

    public LunchSet(Restaurant restaurant, String description) {
        this.restaurant = restaurant;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<SearchTag> getSearchTags() {
        return tags;
    }

    public void addSearchTags(SearchTag searchTag) {
        this.tags.add(searchTag);
    }
    public void removeSearchTag(SearchTag searchTag) {
        this.tags.remove(searchTag);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
