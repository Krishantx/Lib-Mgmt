package io.github.krishantx.lib_mgmt.lib_mgmt.repo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IssueRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void issue(int userId, int bookId) {
        String sql = "insert into issue_log " +
        "(book_id, user_id, issue_date) " +
        "values (?, ?, ?)";
        LocalDate date = LocalDate.now();
        jdbc.update(sql, bookId, userId, date);
    }

    public void returnBook(int bookId) {
        
    }
    
}
