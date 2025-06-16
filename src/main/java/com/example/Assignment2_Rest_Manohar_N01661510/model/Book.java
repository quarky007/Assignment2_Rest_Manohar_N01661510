package com.example.Assignment2_Rest_Manohar_N01661510.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Book title cannot be blank")
    private String title;

    @NotBlank(message = "Book author cannot be blank")
    private String author;


    @NotBlank(message = "Book ISBN cannot be blank")
    @Size(min = 10, max = 13, message = "ISBN must be 10 or 13 digits")
    @NonNull
    @Column(unique = true)
    private String isbn;

    @NotBlank(message = "Book year published cannot be blank")
    private Integer yearPublished;

    // ----- Constructors -----
    public Book() {
    }

    public Book(String title, String author, String isbn, Integer yearPublished) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
    }

    // ----- Getters & Setters -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }
}
