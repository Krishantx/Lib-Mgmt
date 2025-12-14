package io.github.krishantx.lib_mgmt.lib_mgmt.service;

import org.springframework.stereotype.Service;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.Book;
@Service
public class BookService {
    public void addBook(Book book) {
        //TODO Add book to database
    }

    public void issueBook(Book book) {
        //TODO change available to false and store to database
    }

    public void deleteBook(Book book) {
        //TODO delete book from the database
    }

    public void returnBook(Book book) {
        //TODO change available to false and store to database
    }

    
}
