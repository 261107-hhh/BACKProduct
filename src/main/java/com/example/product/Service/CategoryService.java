package com.example.product.Service;

import com.example.product.Dto.CategoryDto;
import com.example.product.Payload.CategoryResponse;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);

	CategoryDto getCategory(int categoryID);

	CategoryResponse getAllCategory();

	String removeCategory(int categoryID);

	String updateCategory(int categoryID, CategoryDto catDto);
}
