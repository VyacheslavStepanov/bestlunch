package com.sweb.bestlunch.dtos;

import com.sweb.bestlunch.entities.Customer;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date created;
    private Date modified;

    public CustomerDTO(String name, String email, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public CustomerDTO(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.phoneNumber = customer.getPhoneNumber();
        this.email = customer.getEmail();
    }
    public CustomerDTO() {}

    public Long getId() {
        return id;
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

