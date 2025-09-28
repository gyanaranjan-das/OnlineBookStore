package com.bookstore.model;

public class CartItem {
    
    private int bookId;
    private String title;
    private double price;
    private String imageUrl;
    private int quantity;

    // Getters and Setters for all fields...
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    // A calculated property to get the subtotal for this item
    public double getSubtotal() {
        return this.price * this.quantity;
    }
}