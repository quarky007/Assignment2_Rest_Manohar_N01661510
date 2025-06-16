package com.example.Assignment2_Rest_Manohar_N01661510.repository;

import com.example.Assignment2_Rest_Manohar_N01661510.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
