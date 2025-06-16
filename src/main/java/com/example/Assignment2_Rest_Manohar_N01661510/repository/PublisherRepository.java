package com.example.Assignment2_Rest_Manohar_N01661510.repository;

import com.example.Assignment2_Rest_Manohar_N01661510.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
