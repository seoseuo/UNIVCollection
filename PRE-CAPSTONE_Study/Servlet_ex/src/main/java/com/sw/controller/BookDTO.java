package com.sw.controller;

public class BookDTO {

	String name;
	String isbn;
	String price;
	
	BookDTO(String n,String i,String p) {
		this.name=n;
		this.isbn=i;
		this.price=p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
