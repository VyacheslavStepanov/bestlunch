package com.sweb.bestlunch.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date created;
    private Date modified;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public User(String name, String email, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
