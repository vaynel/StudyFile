package com.mc.exception.test;

public class Product {
	
	protected String brand;
	protected String pName;
	protected int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String brand, String pName, int price) {
		super();
		this.brand = brand;
		this.pName = pName;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
