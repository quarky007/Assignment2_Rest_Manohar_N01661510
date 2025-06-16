package com.example.Assignment2_Rest_Manohar_N01661510.controller;

import com.example.Assignment2_Rest_Manohar_N01661510.model.Publisher;
import com.example.Assignment2_Rest_Manohar_N01661510.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    // ✅ POST - Add new publisher
    @PostMapping
    public Publisher createPublisher(@Valid @RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // ✅ GET - All publishers
    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    // ✅ GET - Publisher by ID
    @GetMapping("/{id}")
    public Optional<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id);
    }

    // ✅ DELETE - Publisher by ID (optional)
    @DeleteMapping("/{id}")
    public void deletePublisherById(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }

    // ✅ PUT - Update Publisher (optional)
    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable Long id, @RequestBody Publisher updatedPublisher) {
        return publisherRepository.findById(id)
                .map(publisher -> {
                    publisher.setName(updatedPublisher.getName());
                    publisher.setAddress(updatedPublisher.getAddress());
                    publisher.setContact(updatedPublisher.getContact());
                    return publisherRepository.save(publisher);
                })
                .orElseGet(() -> {
                    updatedPublisher.setId(id);
                    return publisherRepository.save(updatedPublisher);
                });
    }
}
