package com.example.sbjsp.entities;

public class Product {

	private int id;
	private String productName;
	private int productAmount;
	
	public Product(int id, String productName, int productAmount) {
		super();
		this.id = id;
		this.productName = productName;
		this.productAmount = productAmount;
	}
	
	public Product() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProductAmount() {
		return productAmount;
	}
	
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
