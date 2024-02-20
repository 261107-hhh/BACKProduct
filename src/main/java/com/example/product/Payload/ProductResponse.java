package com.example.product.Payload;

import java.util.List;

import com.example.product.Dto.ProductDto;

public class ProductResponse {
	
	private List<ProductDto> products;

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	
	

}
