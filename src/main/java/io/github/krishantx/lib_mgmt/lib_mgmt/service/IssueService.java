package io.github.krishantx.lib_mgmt.lib_mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.krishantx.lib_mgmt.lib_mgmt.repo.BookRepo;
import io.github.krishantx.lib_mgmt.lib_mgmt.repo.IssueRepo;


@Service
public class IssueService {
    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private BookRepo bookRepo;
    public void issue(int userId, int bookId) {
        // Change availability of a book to false in the book database
        bookRepo.issue(bookId);
        // Log the issue in the database
        issueRepo.issue(userId, bookId);
    }

    public void returnBook(int bookId) {
        // Change availability of a book to false in the book database
        bookRepo.returnBook(bookId);
        // Log the issue in the database
        issueRepo.returnBook(bookId);
    }

    public int calculateFine(int bookId) {
        // Calculate the number of days overdue and put in the fine function system
        return 0;

    }

    public void payFine(int bookId) {
        // On accessing this end point the book is returned and reissued on the same date, so no longer overdue.
    }
    
}
