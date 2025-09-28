package com.bookstore.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private double price;
    private String description;
    private String imageUrl;
    private int stock;

    // Default constructor
    public Book() {
    }

    // Constructor to initialize fields
    public Book(String title, String author, double price, String imageUrl) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}