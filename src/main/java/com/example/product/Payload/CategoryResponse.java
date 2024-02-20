package com.example.product.Payload;

import java.util.List;

import com.example.product.Dto.CategoryDto;

public class CategoryResponse {

	private List<CategoryDto> categories;
	
	public List<CategoryDto> getCategories() {
		return this.categories;
	}
	
	public void setCategories(List<CategoryDto> cat) {
		this.categories = cat;
	}

}
