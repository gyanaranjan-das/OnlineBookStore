package com.bookstore.model;

// This class is a "ViewModel" - it holds data prepared for the view (JSP).
public class CartItem {
    
    private int bookId;
    private String title;
    private String author;
    private double price;
    private String imageUrl;
    private int quantity;

    // Getters and Setters for all fields...
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    // Calculated property for the subtotal
    public double getSubtotal() {
        return this.price * this.quantity;
    }
}