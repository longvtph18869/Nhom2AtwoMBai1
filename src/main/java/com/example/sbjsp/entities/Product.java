package com.example.sbjsp.entities;

public class Product {

	private int id;
	private String productName;
	private int productAmount;
	
	public Product() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Product(int id, String productName, int productAmount) {
		super();
		this.id = id;
		this.productAmount = productAmount;
		this.productName = productName;
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