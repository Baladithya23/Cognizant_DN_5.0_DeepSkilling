package com.library.repository;

public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("Book saved to repository: " + bookTitle);
    }
}