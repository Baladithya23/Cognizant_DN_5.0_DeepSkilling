package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // No-arg constructor required for setter injection
    public BookService() {
    }

    // Setter method - Spring calls this to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via Setter Injection");
    }

    public void addBook(String title) {
        System.out.println("BookService: Adding book - " + title);
        bookRepository.save(title);
    }
}