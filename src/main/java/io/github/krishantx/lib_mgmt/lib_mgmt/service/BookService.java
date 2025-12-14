package io.github.krishantx.lib_mgmt.lib_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.Book;
import io.github.krishantx.lib_mgmt.lib_mgmt.repo.BookRepo;
@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    public void addBook(Book book) {
        bookRepo.addBook(book);    
    }

    public void issueBook(Book book) {
        //TODO change available to false and store to database
    }

    public void deleteBook(int bookId) {
        //TODO delete book from the database
        bookRepo.deleteBook(bookId);
    }

    public void returnBook(Book book) {
        //TODO change available to false and store to database
    }

    public Book getBook(int bookId) {
        return bookRepo.getBook(bookId);
    }

    public List<Book> allBooks() {
        return bookRepo.allBooks();
    }

    public void updateBook(Book book) {
        bookRepo.updateBook(book);
    }

    
}
