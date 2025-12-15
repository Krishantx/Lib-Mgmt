package io.github.krishantx.lib_mgmt.lib_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.Book;
import io.github.krishantx.lib_mgmt.lib_mgmt.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/book/{bookId}")
    public Book getBook(@PathVariable("bookId") int bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/book")
    public void updateBook(@RequestBody Book book) {
         bookService.updateBook(book);
    }

    @GetMapping("/books")
    public List<Book> allBooks() {
        List<Book> books = bookService.allBooks();
        return books;
    }

    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }
}
