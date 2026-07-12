package com.example;

public class BookService {

    private BookRepository repository;

    public BookService() {
        System.out.println("BookService Object Created");
    }

    public void setBookRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void showService() {
        repository.display();
    }
}