package io.github.krishantx.lib_mgmt.lib_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.krishantx.lib_mgmt.lib_mgmt.service.IssueService;


@RestController
public class IssueController {
    @Autowired
    private IssueService issueService;
    
    @GetMapping("/issue")
    public void issue(@RequestParam int userId, @RequestParam int bookId) {
        issueService.issue(userId, bookId);    
    }

    @GetMapping("/return")
    public void returnBook(@RequestParam int bookId) {
        issueService.returnBook(bookId);
    }

    @GetMapping("/fine")
    public int calculateFine(@RequestParam int bookId) {
        return issueService.calculateFine(bookId);
    }

    @GetMapping("/payFine")
    public void payFine(@RequestParam int bookId) {
        issueService.payFine(bookId);
    } 
}
