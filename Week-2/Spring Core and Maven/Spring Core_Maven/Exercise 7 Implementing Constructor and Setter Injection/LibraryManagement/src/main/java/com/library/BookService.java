package com.library;

public class BookService {

    private BookRepository bookRepository;

  
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created using CONSTRUCTOR injection");
    }

   
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService dependency set using SETTER injection");
    }

    public void displayBook(int id) {
        System.out.println(bookRepository.getBookById(id));
    }
}