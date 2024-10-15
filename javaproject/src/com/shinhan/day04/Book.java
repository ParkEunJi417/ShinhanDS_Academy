package com.shinhan.day04;

public class Book {

	private String title;
	private int price;
	
	public Book(String title, int price) {
		this.title=title;
		this.price=price;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getPrice() {
		return this.price;
	}

}
