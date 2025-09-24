package com.bookstore.model;

public class Cart {
	
	private int id;
	private int userId;
	private int bookId;
	private int quantity;
	
	public Cart() {
		
	}
	
	public Cart(int id, int userId, int bookId, int quantity) {
		this.id=id;
		this.userId=userId;
		this.bookId=bookId;
		this.quantity=quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId=userId;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId=bookId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
}
