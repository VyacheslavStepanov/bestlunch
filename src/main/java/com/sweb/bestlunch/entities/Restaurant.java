package com.sweb.bestlunch.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty(message = "Please provide a name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "phone_number")
    @NotEmpty(message = "Please provide an phone number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "restaurant", optional = false)
    private User administrator;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User getAdministrator() {
        return administrator;
    }

    public void setAdministrator(User administrator) {
        this.administrator = administrator;
    }

    public void setId(Long id) { this.id = id; }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
