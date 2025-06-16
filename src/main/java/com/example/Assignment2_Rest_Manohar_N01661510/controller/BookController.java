package com.example.Assignment2_Rest_Manohar_N01661510.controller;

import com.example.Assignment2_Rest_Manohar_N01661510.model.Book;
import com.example.Assignment2_Rest_Manohar_N01661510.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/test")
    public String testEndpoint() {
        return "BookController is working!";
    }
    // ✅ POST - Add new book
    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // ✅ GET - All books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ✅ GET - Book by ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    // ✅ DELETE - Book by ID (optional)
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    // ✅ PUT - Update Book (optional)
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setIsbn(updatedBook.getIsbn());
                    book.setYearPublished(updatedBook.getYearPublished());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setId(id);
                    return bookRepository.save(updatedBook);
                });
    }
}
