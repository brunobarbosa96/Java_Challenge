package com.mlchallenge.api.model;

import javax.validation.constraints.NotNull;

public class Product {

	@NotNull
	private String id;
	@NotNull
	private String ean;
	@NotNull
	private String title;
	@NotNull
	private String brand;
	@NotNull
	private double price;
	@NotNull
	private int stock;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
