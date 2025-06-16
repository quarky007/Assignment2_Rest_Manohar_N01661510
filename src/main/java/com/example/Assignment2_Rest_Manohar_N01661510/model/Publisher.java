package com.example.Assignment2_Rest_Manohar_N01661510.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Publisher name cannot be blank")
    private String name;

    @NotBlank(message = "Publisher address cannot be blank")
    private String address;

    @NotBlank(message = "Publisher contact cannot be blank")
    private String contact;

    // ----- Constructors -----
    public Publisher() {
    }

    public Publisher(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    // ----- Getters & Setters -----
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
