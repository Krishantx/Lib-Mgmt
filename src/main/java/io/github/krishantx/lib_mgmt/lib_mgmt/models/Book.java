package io.github.krishantx.lib_mgmt.lib_mgmt.models;


public class Book {
    private int bookId;
    private boolean available;
    private String bookTitle;
    private String genre;
    private String author;
    private float cost;
    
    public int getBookId() { 
        return bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookName(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    
}
