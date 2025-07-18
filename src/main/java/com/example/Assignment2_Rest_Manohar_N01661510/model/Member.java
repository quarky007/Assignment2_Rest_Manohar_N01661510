package com.example.Assignment2_Rest_Manohar_N01661510.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Member name cannot be blank")
    private String name;

    @NotBlank(message = "Member email cannot be blank")
    @Column(unique = true)
    private String email;


    private String membershipDate;

    // ----- Constructors -----
    public Member() {
    }

    public Member(String name, String email, String membershipDate) {
        this.name = name;
        this.email = email;
        this.membershipDate = membershipDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(String membershipDate) {
        this.membershipDate = membershipDate;
    }
}
