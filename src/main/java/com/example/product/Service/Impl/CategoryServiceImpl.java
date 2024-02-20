package com.example.product.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Dto.CategoryDto;
import com.example.product.Dto.ProductDto;
import com.example.product.Entity.Category;
import com.example.product.Exception.ResourceNotFoundException;
import com.example.product.Payload.CategoryResponse;
import com.example.product.Repo.CategoryRepository;
import com.example.product.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto category) {
		// TODO Auto-generated method stub
		CategoryDto cat = mapper.map(repo.save(mapper.map(category, Category.class)),CategoryDto.class);
		return cat ;
	}

	@Override
	public CategoryDto getCategory(int categoryID) {
		// TODO Auto-generated method stub
		Optional<Category> cat = repo.findById(categoryID);
		
		return mapper.map(cat, CategoryDto.class);
	}

	@Override
	public String removeCategory(int categoryID) {
		// TODO Auto-generated method stub
		Category category = repo.findById(categoryID).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
		try {
			repo.deleteById(categoryID);
			return "Category Removed";
		} catch (Exception e) {
			// TODO: handle exception
			return "Category cannot be Removed";
		}
	}
	
	@Override
	public String updateCategory(int categoryID, CategoryDto catDto) {
		// TODO Auto-generated method stub
		CategoryDto category = mapper.map(repo.findById(categoryID).orElseThrow(() -> new ResourceNotFoundException("Category Not Found")), CategoryDto.class);
		category.setName(catDto.getName());
		
		try {
			repo.save(mapper.map(category, Category.class));
			return "Category Updated";
		} catch (Exception e) {
			// TODO: handle exception
			return "Category cannot be Updated";
		}
	}

	@Override
	public CategoryResponse getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> cat = repo.findAll();
		CategoryResponse res = new CategoryResponse();
		List<CategoryDto> data = cat.stream().map((e) -> mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
		res.setCategories(data);
		return res;
	}
	

}
