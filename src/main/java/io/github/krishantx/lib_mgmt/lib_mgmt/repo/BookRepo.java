package io.github.krishantx.lib_mgmt.lib_mgmt.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import io.github.krishantx.lib_mgmt.lib_mgmt.models.Book;

@Repository
public class BookRepo {
    
    @Autowired 
    private JdbcTemplate jdbc;

    public void addBook(Book book) {   

        String sql = "insert into books " + 
        "(book_id, available, book_title, genre, author, cost) " + 
        " values (?, ?, ?, ?, ?, ?)";

        jdbc.update(
            sql, 
            book.getBookId(),
            book.isAvailable(),
            book.getBookTitle(),
            book.getGenre(),
            book.getAuthor(),
            book.getCost()
        );


    }

    public void updateBook(Book book) {
        String sql = "update books " +
        "set available = ? ," +
        "book_title = ? ," +
        "genre = ? ," +
        "author = ?, " +
        "cost = ? " +
        "where book_id = ?";

        jdbc.update(
            sql,
            book.isAvailable(),
            book.getBookTitle(),
            book.getGenre(),
            book.getAuthor(),
            book.getCost(),
            book.getBookId()
        );
    }

    public Book getBook(int bookId) {
        String sql = "select * from books where book_id = " + bookId;
        List<Book> books = jdbc.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setAuthor(rs.getString("author"));
                book.setAvailable(rs.getBoolean("available"));
                book.setBookName(rs.getString("book_title"));
                book.setCost(rs.getFloat("cost"));
                book.setGenre(rs.getString("genre"));
                return book;
            }
        });

        if (books.isEmpty()) { return null; }
        return books.get(0);
    }

    public void deleteBook(int bookId) {
        String sql = "delete from books where book_id = ?";
        jdbc.update(sql, bookId);
    }

    public List<Book> allBooks() {
        String sql = "select * from books";
        List<Book> books = jdbc.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_title"));
                book.setAuthor(rs.getString("author"));
                book.setAvailable(rs.getBoolean("available"));
                book.setCost(rs.getFloat("cost"));
                book.setGenre(rs.getString("genre"));
                return book;
            }
        });
        return books;
    }

    public void issue(int bookId) {
        String sql = "update books " +
        "set available = false " +
        "where book_id = ?";
        
        jdbc.update(sql, bookId);
    }

    public void returnBook(int bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
    }
}
