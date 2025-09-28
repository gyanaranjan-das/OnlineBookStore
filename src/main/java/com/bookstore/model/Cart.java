package com.bookstore.model;

public class Cart {

    private int id;
    private int userId;
    private int bookId;
    private int quantity;

    // Default constructor
    public Cart() {
    }

    // Constructor to initialize all fields
    public Cart(int id, int userId, int bookId, int quantity) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    // Getters and Setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}