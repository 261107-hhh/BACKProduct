package com.example.product.Dto;

import com.example.product.Entity.Category;

public class ProductDto {

	private Integer srno;

	private String name;

	private String description;

	private String images;

	private boolean stock;

	private boolean available;

	private int quantity;

	private String vendor;

	private float price;
	
	private Category category;

	public ProductDto() {
		super();
	}

	public ProductDto(Integer srno, String name, String description, String images, boolean stock, boolean available,
			int quantity, String vendor, float price, Category category) {
		super();
		this.srno = srno;
		this.name = name;
		this.description = description;
		this.images = images;
		this.stock = stock;
		this.available = available;
		this.quantity = quantity;
		this.vendor = vendor;
		this.price = price;
		this.category = category;
	}

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
