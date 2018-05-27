package com.sweb.bestlunch.entities.lunch;

import com.sweb.bestlunch.entities.customer.Customer;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LunchSet {
    @Id @GeneratedValue
    private Long id;
    private Customer customer;
    @ManyToMany
    @JoinTable(name="lunchset_searchtag",
        joinColumns=@JoinColumn(name="lunchset_id"),
        inverseJoinColumns =@JoinColumn(name="searchtag_id")
    )
    private List<SearchTag> searchTags = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="lunchset_product",
        joinColumns=@JoinColumn(name="lunchset_id"),
        inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products = new ArrayList<>();
    private String description;

    public LunchSet(Customer customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SearchTag> getSearchTags() {
        return searchTags;
    }

    public void addSearchTags(SearchTag searchTag) {
        this.searchTags.add(searchTag);
    }
    public void removeSearchTag(SearchTag searchTag) {
        this.searchTags.remove(searchTag);
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
