package com.library;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created!");
    }

    public String getBookById(int id) {
        return "Book with ID: " + id + " - 'Effective Java'";
    }
}